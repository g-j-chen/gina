/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lootsharing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;


/**
 *
 * @author ginaj
 */
public class LootSharing {


    public static void main(String[] args) {
        // TODO code application logic here
        List<String> names = Arrays.asList("Fin", "Mir", "Wiz", "Snake Catcher", "Niman");
        List<String> loot = Arrays.asList("8gp 5sp", "100gp gems x5", "gold ring with black flying snake symbol 25gp", "4pp 13gp", "35gp", "12gp 55sp 87cp", "silver salt and pepper shakers set 25gp", "holy symbol of sylvanus 25gp", "12sp");
        HashMap<String, HashMap> map = lootSharing(5, names, loot);
        System.out.println(map);
    }
    
    public static HashMap<String, HashMap> lootSharing(int noOfPpl, List<String> names, List<String> loot) {
        HashMap<String, Integer> goldAndGemstones = new HashMap<>();
        HashMap<String, Double> otherLoot = new HashMap<>();
        
        for(String item : loot) {
            if(item.toLowerCase().contains("gemstones")) {
                int value = Integer.parseInt(item.replaceAll("[^0-9]", ""));
                if(!goldAndGemstones.containsKey("gemstones")) {
                    goldAndGemstones.put("gemstones", value);
                } else {
                    goldAndGemstones.put("gemstones", goldAndGemstones.get("gemstones") + value);
                }
                continue;
            }
            
            String[] array = item.toLowerCase().split(" ");
            boolean isGold = true;
            for(String s : array) {
                if(s.matches("[a-z]+")) {
                    isGold = false;
                    break;
                }
            }
            if(isGold) {
                for(String s : array) {
                    int value = Integer.parseInt(s.replaceAll("[a-z]+", ""));
                    String type = s.replaceAll("[0-9]+", "");
                    if(!goldAndGemstones.containsKey(type)) {
                        goldAndGemstones.put(type, value);
                    } else {
                        goldAndGemstones.put(type, goldAndGemstones.get(type) + value);
                    }
                }
                continue;
            }
            if(!isGold) {
                String lootItem = "";
                double valueInGold = 0;
                int amount = 1;
                for(String s : array) {
                    if(s.matches("[a-z]+")) {
                        lootItem += s + " ";
                    } else if(s.contains("pp") || s.contains("gp") || s.contains("ep") || s.contains("sp") || s.contains("cp")) {
                        double temp = Double.parseDouble(s.replaceAll("[a-z]+", ""));
                        String type = s.replaceAll("[0-9]+", "");
                        switch (type) {
                            case "pp":
                                valueInGold = temp * 10;
                                break;
                            case "gp":
                                valueInGold = temp;
                                break;
                            case "ep":
                                valueInGold = temp / 2;
                                break;
                            case "sp":
                                valueInGold = temp / 10;
                                break;
                            case "cp":
                                valueInGold = temp / 100;
                                break;
                            default:
                                break;
                        }
                    } else if(s.matches("x{1}?[0-9]+")) {
                        amount = Integer.parseInt(s.replaceAll("[a-z]+", ""));
                    }
                }

                otherLoot.put(lootItem.trim(), valueInGold);
                if(amount > 1) {
                    int n = 2;
                    for(int i = 2; i <= amount; i++) {
                        String temp = lootItem + String.valueOf(n++);
                        otherLoot.put(temp, valueInGold);
                    }
                }
            }
        }

        System.out.println(goldAndGemstones);
        
        Map<String, Double> sortedOtherLoot = otherLoot
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(sortedOtherLoot);
        
        LinkedHashMap<String, HashMap> dividedLootMap = new LinkedHashMap<>();
        List<HashMap<String, String>> dividedLootList = new ArrayList<>();
        for(int i = 0; i < names.size(); i++) {
            HashMap<String, String> map = new HashMap<>();
            dividedLootList.add(map);
        }
        int[] runningValue = new int[names.size()];
        

        for(Map.Entry<String, Double> entry : sortedOtherLoot.entrySet()) {
            int i = getMinValueIndex(runningValue);
           
            String lootAmount = entry.getValue() + "gp";
            dividedLootList.get(i).put(entry.getKey(), lootAmount);
            runningValue[i] += entry.getValue();
            if(i + 1 == names.size()) {
                i = 0;
            } else {
                i++;
            }         
        }
        
        int gemstonesAmount = goldAndGemstones.containsKey("gemstones") ? goldAndGemstones.get("gemstones") : 0;
        while(gemstonesAmount > 0) {
            int leastWorthIndex = getMinValueIndex(runningValue);
            int nextLowestIndex = getNextLowestIndex(runningValue, leastWorthIndex);
            int[] leastWorthArray = new int[noOfPpl];
            int count = 0;
            for(int i = 0; i < noOfPpl; i++) {
                if(runningValue[i] == runningValue[leastWorthIndex]) {
                    leastWorthArray[i] = 1;
                    count++;
                }
            }
            
            int diff = runningValue[nextLowestIndex] - runningValue[leastWorthIndex];
            if(diff == 0) {
                int gemstonesGiven = gemstonesAmount / noOfPpl;
                int remainder = gemstonesAmount % noOfPpl;
                for(int i = 0; i < noOfPpl; i++) {
                    String lootAmount = gemstonesGiven + "gp";
                    runningValue[i] += gemstonesGiven;
                    HashMap<String, String> map = dividedLootList.get(i);
                    if(!map.containsKey("gemstones")) {
                        map.put("gemstones", lootAmount);
                    } else {
                        int currAmount = Integer.parseInt(map.get("gemstones").replaceAll("[a-z]+", ""));
                        currAmount += gemstonesGiven;
                        String updatedAmount = currAmount + "gp";
                        map.put("gemstones", updatedAmount);
                    }
                }
                
                if(remainder > 0) {
                    runningValue[noOfPpl - 1] += remainder;
                    HashMap<String, String> map = dividedLootList.get(noOfPpl - 1);
                    int currAmount = Integer.parseInt(map.get("gemstones").replaceAll("[a-z]+", ""));
                    currAmount += remainder;
                    String updatedAmount = currAmount + "gp";
                    map.put("gemstones", updatedAmount);
                }
                
                gemstonesAmount = 0;
                break;
            }
            
            if(count == 1) {
                if(gemstonesAmount < diff) {
                    diff = gemstonesAmount;
                }
                String lootAmount = diff + "gp";
                runningValue[leastWorthIndex] += diff;
                HashMap<String, String> map = dividedLootList.get(leastWorthIndex);
                if(!map.containsKey("gemstones")) {
                    map.put("gemstones", lootAmount);
                } else {
                    int currAmount = Integer.parseInt(map.get("gemstones").replaceAll("[a-z]+", ""));
                    currAmount += diff;
                    String updatedAmount = currAmount + "gp";
                    map.put("gemstones", updatedAmount);
                }
                gemstonesAmount -= diff;
                continue;
            }
            
            if(count > 1) {
                int totalNeeded = diff * count;
                if(totalNeeded <= gemstonesAmount) {
                    for(int i = 0; i < noOfPpl; i++) {
                        if(leastWorthArray[i] == 1) {
                            String lootAmount = diff + "gp";
                            runningValue[i] += diff;
                            HashMap<String, String> map = dividedLootList.get(i);
                            if(!map.containsKey("gemstones")) {
                                map.put("gemstones", lootAmount);
                            } else {
                                int currAmount = Integer.parseInt(map.get("gemstones").replaceAll("[a-z]+", ""));
                                currAmount += diff;
                                String updatedAmount = currAmount + "gp";
                                map.put("gemstones", updatedAmount);
                            }
                        }
                    }
                } else {
                    int gemstonesGiven = gemstonesAmount / count;
                    int remainder = gemstonesAmount % count;
                    int lastIndex = 0;
                    for(int i = 0; i < noOfPpl; i++) {
                        if(leastWorthArray[i] == 1) {
                            String lootAmount = gemstonesGiven + "gp";
                            runningValue[i] += gemstonesGiven;
                            HashMap<String, String> map = dividedLootList.get(i);
                            if(!map.containsKey("gemstones")) {
                                map.put("gemstones", lootAmount);
                            } else {
                                int currAmount = Integer.parseInt(map.get("gemstones").replaceAll("[a-z]+", ""));
                                currAmount += gemstonesGiven;
                                String updatedAmount = currAmount + "gp";
                                map.put("gemstones", updatedAmount);
                            }
                            if(i > lastIndex) {
                                lastIndex = i;
                            }
                        }
                    }
                    
                    if(remainder > 0) {
                        runningValue[lastIndex] += remainder;
                        HashMap<String, String> map = dividedLootList.get(lastIndex);
                        int currAmount = Integer.parseInt(map.get("gemstones").replaceAll("[a-z]+", ""));
                        currAmount += remainder;
                        String updatedAmount = currAmount + "gp";
                        map.put("gemstones", updatedAmount);
                    }
                }
                gemstonesAmount -= totalNeeded;
            }
        }
        
        int ppInGoldValue = goldAndGemstones.containsKey("pp") ? (goldAndGemstones.get("pp") * 10) : 0;
        
        if(!goldAndGemstones.containsKey("cp")) {
            goldAndGemstones.put("cp", 0);
        }
        
        int ep = goldAndGemstones.containsKey("ep") ? goldAndGemstones.get("ep") : 0;
        if(ep % 2 != 0) {
            int remainder = ep % 2;
            int cpValue = remainder * 50;
            goldAndGemstones.put("cp", goldAndGemstones.get("cp") + cpValue);
        }
        int epInGoldValue = ep / 2;
        
        int sp = goldAndGemstones.containsKey("sp") ? goldAndGemstones.get("sp") : 0;
        if(sp % 10 != 0) {
            int remainder = sp % 10;
            int cpValue = remainder * 10;
            goldAndGemstones.put("cp", goldAndGemstones.get("cp") + cpValue);
        }
        int spInGoldValue = sp / 10;
        
        int totalGoldValue = goldAndGemstones.get("gp") + ppInGoldValue + epInGoldValue + spInGoldValue;
        int totalCopperValue = goldAndGemstones.get("cp");
        
        while(totalGoldValue > 0) {
            int leastWorthIndex = getMinValueIndex(runningValue);
            int nextLowestIndex = getNextLowestIndex(runningValue, leastWorthIndex);
            int[] leastWorthArray = new int[noOfPpl];
            int count = 0;
            for(int i = 0; i < noOfPpl; i++) {
                if(runningValue[i] == runningValue[leastWorthIndex]) {
                    leastWorthArray[i] = 1;
                    count++;
                }
            }
            
            int diff = runningValue[nextLowestIndex] - runningValue[leastWorthIndex];
            if(diff == 0) {
                int goldGiven = totalGoldValue / noOfPpl;
                int remainder = totalGoldValue % noOfPpl;
                for(int i = 0; i < noOfPpl; i++) {
                    String lootAmount = String.valueOf(goldGiven);
                    runningValue[i] += goldGiven;
                    HashMap<String, String> map = dividedLootList.get(i);
                    if(!map.containsKey("gp")) {
                        map.put("gp", lootAmount);
                    } else {
                        int currAmount = Integer.parseInt(map.get("gp"));
                        currAmount += goldGiven;
                        map.put("gp", String.valueOf(currAmount));
                    }
                }
                if(remainder > 0) {
                    runningValue[noOfPpl - 1] += remainder;
                    HashMap<String, String> map = dividedLootList.get(noOfPpl - 1);
                    int currAmount = Integer.parseInt(map.get("gp"));
                    currAmount += remainder;
                    map.put("gp", String.valueOf(currAmount));
                }
                
                totalGoldValue = 0;
                break;
            }
            
            if(count == 1) {
                if(totalGoldValue < diff) {
                    diff = totalGoldValue;
                }
                String lootAmount = String.valueOf(diff);
                runningValue[leastWorthIndex] += diff;
                HashMap<String, String> map = dividedLootList.get(leastWorthIndex);
                if(!map.containsKey("gp")) {
                    map.put("gp", lootAmount);
                } else {
                    int currAmount = Integer.parseInt(map.get("gp"));
                    currAmount += diff;
                    map.put("gp", String.valueOf(currAmount));
                }
                totalGoldValue -= diff;
                continue;
            }
            
            if(count > 1) {
                int totalNeeded = diff * count;
                if(totalNeeded <= totalGoldValue) {
                    for(int i = 0; i < noOfPpl; i++) {
                        if(leastWorthArray[i] == 1) {
                            String lootAmount = String.valueOf(diff);
                            runningValue[i] += diff;
                            HashMap<String, String> map = dividedLootList.get(i);
                            if(!map.containsKey("gp")) {
                                map.put("gp", lootAmount);
                            } else {
                                int currAmount = Integer.parseInt(map.get("gp"));
                                currAmount += diff;
                                map.put("gp", String.valueOf(currAmount));
                            }
                        }
                    }
                } else {
                    int goldGiven = totalGoldValue / count;
                    int remainder = totalGoldValue % count;
                    int lastIndex = 0;
                    for(int i = 0; i < noOfPpl; i++) {
                        if(leastWorthArray[i] == 1) {
                            String lootAmount = String.valueOf(goldGiven);
                            runningValue[i] += goldGiven;
                            HashMap<String, String> map = dividedLootList.get(i);
                            if(!map.containsKey("gp")) {
                                map.put("gp", lootAmount);
                            } else {
                                int currAmount = Integer.parseInt(map.get("gp"));
                                currAmount += goldGiven;
                                map.put("gp", String.valueOf(currAmount));
                            }
                            if(i > lastIndex) {
                                lastIndex = i;
                            }
                        }
                    }
                    
                    if(remainder > 0) {
                        runningValue[lastIndex] += remainder;
                        HashMap<String, String> map = dividedLootList.get(lastIndex);
                        int currAmount = Integer.parseInt(map.get("gp"));
                        currAmount += remainder;
                        map.put("gp", String.valueOf(currAmount));
                    }
                }
                totalGoldValue -= totalNeeded;
            }
        }

        while(totalCopperValue > 0) {
            int leastWorthIndex = getMinValueIndex(runningValue);
            int nextLowestIndex = getNextLowestIndex(runningValue, leastWorthIndex);
            int[] leastWorthArray = new int[noOfPpl];
            int count = 0;
            for(int i = 0; i < noOfPpl; i++) {
                if(runningValue[i] == runningValue[leastWorthIndex]) {
                    leastWorthArray[i] = 1;
                    count++;
                }
            }
            
            int diff = runningValue[nextLowestIndex] - runningValue[leastWorthIndex];
            if(diff == 0) {
                int copperGiven = totalCopperValue / noOfPpl;
                int remainder = totalCopperValue % noOfPpl;
                for(int i = 0; i < noOfPpl; i++) {
                    String lootAmount = String.valueOf(copperGiven);
                    runningValue[i] += copperGiven;
                    HashMap<String, String> map = dividedLootList.get(i);
                    if(!map.containsKey("cp")) {
                        map.put("cp", lootAmount);
                    } else {
                        int currAmount = Integer.parseInt(map.get("cp"));
                        currAmount += copperGiven;
                        map.put("cp", String.valueOf(currAmount));
                    }
                }
                if(remainder > 0) {
                    runningValue[noOfPpl - 1] += remainder;
                    HashMap<String, String> map = dividedLootList.get(noOfPpl - 1);
                    int currAmount = Integer.parseInt(map.get("cp"));
                    currAmount += remainder;
                    map.put("cp", String.valueOf(currAmount));
                }
                
                totalCopperValue = 0;
                break;
            }
            
            if(count == 1) {
                if(totalCopperValue < diff) {
                    diff = totalCopperValue;
                }
                String lootAmount = String.valueOf(diff);
                runningValue[leastWorthIndex] += diff;
                HashMap<String, String> map = dividedLootList.get(leastWorthIndex);
                if(!map.containsKey("cp")) {
                    map.put("cp", lootAmount);
                } else {
                    int currAmount = Integer.parseInt(map.get("cp"));
                    currAmount += diff;
                    map.put("cp", String.valueOf(currAmount));
                }
                totalCopperValue -= diff;
                continue;
            }
            
            if(count > 1) {
                int totalNeeded = diff * count;
                if(totalNeeded <= totalCopperValue) {
                    for(int i = 0; i < noOfPpl; i++) {
                        if(leastWorthArray[i] == 1) {
                            String lootAmount = String.valueOf(diff);
                            runningValue[i] += diff;
                            HashMap<String, String> map = dividedLootList.get(i);
                            if(!map.containsKey("cp")) {
                                map.put("cp", lootAmount);
                            } else {
                                int currAmount = Integer.parseInt(map.get("cp"));
                                currAmount += diff;
                                map.put("cp", String.valueOf(currAmount));
                            }
                        }
                    }
                } else {
                    int copperGiven = totalCopperValue / count;
                    int remainder = totalCopperValue % count;
                    int lastIndex = 0;
                    for(int i = 0; i < noOfPpl; i++) {
                        if(leastWorthArray[i] == 1) {
                            String lootAmount = String.valueOf(copperGiven);
                            runningValue[i] += copperGiven;
                            HashMap<String, String> map = dividedLootList.get(i);
                            if(!map.containsKey("cp")) {
                                map.put("cp", lootAmount);
                            } else {
                                int currAmount = Integer.parseInt(map.get("cp"));
                                currAmount += copperGiven;
                                map.put("cp", String.valueOf(currAmount));
                            }
                            if(i > lastIndex) {
                                lastIndex = i;
                            }
                        }
                    }
                    
                    if(remainder > 0) {
                        runningValue[lastIndex] += remainder;
                        HashMap<String, String> map = dividedLootList.get(lastIndex);
                        int currAmount = Integer.parseInt(map.get("cp"));
                        currAmount += remainder;
                        map.put("cp", String.valueOf(currAmount));
                    }
                }
                totalCopperValue -= totalNeeded;
            }
        }
        
        for(int j = 0; j < names.size(); j++) {
            dividedLootMap.put(names.get(j), dividedLootList.get(j));
        }
        
        return dividedLootMap;
    }
    
    public static int getMinValueIndex(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
    
    public static int getNextLowestIndex(int[] array, int leastIndex) {
        int diff = Integer.MAX_VALUE;
        int nextLowest = 0;
        for(int i = 0; i < array.length; i++) {
            int temp = Math.abs(array[i] - array[leastIndex]);
            if(temp < diff && temp != 0) {
                diff = temp;
                nextLowest = i;
            }
        }
        return nextLowest;
    }
}
