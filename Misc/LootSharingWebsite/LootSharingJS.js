var playerString;
var lootString;
var playerList;
var lootList;
var numPlayers;
var allocatedLootList = [];


document.getElementById("addPlayers").onclick = function() {
	playerString = document.getElementById("playerNames").value;
	console.log(playerString);
}


document.getElementById("addLoot").onclick = function() {
	lootString = document.getElementById("lootNames").value;
	console.log(lootString);
}


document.getElementById("playerClear").onclick = function() {
	document.getElementById("playerNames").value = "";
	playerString = "";
}


document.getElementById("lootClear").onclick = function() {
	document.getElementById("lootNames").value = "";
	lootString = "";
}


function lootShare() {
	if (playerString === "") {
		alert("No one is getting any loot :(");
	} else {
		playerList = playerString.split(",");
		numPlayers = playerList.length;
		for (var i = 0; i < numPlayers; i++) {
			playerList[i] = playerList[i].trim();
		}
	}

	if (lootString === "") {
		alert("There's no loot!");
	} else {
		lootList = lootString.split(",");
		for (var i = 0; i < lootList.length; i++) {
			lootList[i] = lootList[i].trim();
		}
	}

	console.log("player list: " + playerList);
	console.log("loot list: " + lootList);

	var shuffledPlayers = shuffle(Array.from(Array(numPlayers).keys()));

	var separatedLootList = separateLoot(lootList);
	var goldAndGemstones = separatedLootList[0];
	var sortedLootItems = separatedLootList[1].sort((a, b) => (b.value - a.value));

	console.log("gold and gemstones:");
	console.log(goldAndGemstones);
	console.log("sorted loot items:");
	console.log(sortedLootItems);

	allocateLoot(sortedLootItems);
	allocateGoldAndGemstones(goldAndGemstones);
}


function separateLoot(array) {
	var goldAndGemstones = Array(6).fill(0); // ind 0: pp, 1: gp, 2: ep, 3: sp, 4:cp, 5: gemstones
	var lootItemArray = [];

	for (var i = 0; i < array.length; i++) {
		var item = array[i];
		if (item.toLowerCase().includes("gemstones")) {
			var value = parseInt(item.replace(/[^0-9]/g, ""), 10);
			goldAndGemstones[5] += value;
			continue;
		}

		var itemStringArray = item.split(" ");
		var len = itemStringArray.length;
		var isGold = true;
		for (var j = 0; j < len; j++) {
			var s = itemStringArray[j];
			if (s.match(/^[a-zA-Z]+$/)) {
				isGold = false;
				break;
			}
		}

		if (isGold) {
			for (var j = 0; j < len; j++) {
				var s = itemStringArray[j];
				var value = parseInt(s.replace(/[^0-9]/g, ""), 10);
				var type = s.substring(s.length - 2, s.length);
				var ind;
				switch(type) {
					case "pp":
						ind = 0;
						break;
					case "gp":
						ind = 1;
						break;
					case "ep":
						ind = 2;
						break;
					case "sp":
						ind = 3;
						break;
					case "cp":
						ind = 4;
						break;
					default:
						break;
				}
				goldAndGemstones[ind] += value;
			}
			continue;
		}

		if (!isGold) {
			var lootItem = "";
			var valueInGold = 0;
			var amount = 1;
			for (var j = 0; j < len; j++) {
				var s = itemStringArray[j];
				if (s.match(/^[a-zA-Z]+$/)) {
					lootItem += s + " ";
				} else if (s.includes("pp") || s.includes("gp") || s.includes("ep") || s.includes("sp") || s.includes("cp")) {
					var temp = parseInt(s.replace(/[^0-9]/g, ""), 10);
					var type = s.substring(s.length - 2, s.length);
					valueInGold = getValueInGold(temp, type);
				} else if (s.match(/x{1}[0-9]+/)) {
					amount = parseInt(s.replace(/[^0-9]/g, ""), 10);
				}
			}
			var itemTuple = Object.freeze({name: lootItem, value: valueInGold, actual: temp.toString() + type});
			for (var k = 0; k < amount; k++) {
				lootItemArray.push(itemTuple);
			}
		}
	}
	return [goldAndGemstones, lootItemArray];
}


function allocateLoot(array) {
	for (var i = 0; i < numPlayers; i++) {
		var v = [];
		const c = {total: 0, list: v};
		allocatedLootList.push(c);
	}

	for (var i = 0; i < array.length; i++) {
		var item = array[i];
		var leastWorthInd = getLeastWorth(allocatedLootList);
		allocatedLootList[leastWorthInd].total += item.value;
		allocatedLootList[leastWorthInd].list.push(item);
	}
	console.log("allocated loot list: ");
	console.log(allocatedLootList);
}


function allocateGoldAndGemstones(array) {
	
}


function getLeastWorth(allocatedLootList) {
	var min = Number.MAX_SAFE_INTEGER;
	var index = -1;
	
	for (var i = 0; i < numPlayers; i++) {
		if (allocatedLootList[i].total < min) {
			min = allocatedLootList[i].total;
			index = i;
		}
	}
	return index;
}


function getValueInGold(amt, type) {
	switch(type) {
		case "pp":
			return amt * 10;
		case "gp":
			return amt;
		case "ep":
			return amt / 2;
		case "sp":
			return amt / 10;
		case "cp":
			return amt / 100;
		default:
			return;
	}
}


function shuffle(array) {
	var currIndex = array.length;
	var temp, randomIndex;

	while (currIndex != 0) {
		randomIndex = Math.floor(Math.random() * currIndex);
		currIndex -= 1;
		temp = array[currIndex];
		array[currIndex] = array[randomIndex];
		array[randomIndex] = temp;
	}
	return array;
}


function compareIgnoreCase(a, b) {
	return typeof a === 'string' && typeof b === 'string' ? a.localeCompare(b, undefined, {sensitivity: 'accent'}) === 0 : a === b;
}


document.getElementById("split").onclick = function() {
	lootShare();
}