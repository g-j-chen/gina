#include <bits/stdc++.h>

using namespace std;

string ans;
vector<int> adj[26];
bool cycle;
bool visited[26], act[26];

void dfs(int u) {
	visited[u] = true;
	act[u] = true;
	for(int v : adj[u]) {
		if(act[v] && u != v) {
			cycle = true;
		} else {
			if(!visited[v]) {
				dfs(v);
			}
		}
	}
	act[u] = false;
	ans += (char) (u + 'A');
}

string solve() {
	int r, c;
	cin >> r >> c;
	set<char> set;
	string arr[r];
	for(int i = 0; i < r; i++) {
		cin >> arr[i];
		for(char c : arr[i]) {
			set.insert(c);
		}
		if(i) {
			for(int j = 0; j < c; j++) {
				adj[arr[i-1][j] - 'A'].push_back(arr[i][j] - 'A');
			}
		}
	}
	ans = "";
	memset(visited, false, 26);
	memset(act, false, 26);
	cycle = false;
	for(char c : set) {
		if(!visited[c - 'A']) {
			dfs(c - 'A');
		}
	}	
	if(cycle) {
		ans = "-1";
	}
	for(int i = 0; i < 26; i++) {
		adj[i].clear();
	}
	return ans;
}

int main() {
	int t;
	cin >> t;
	for(int tc = 1; tc <= t; tc++) {
		string a = solve();
		cout << "Case #" << tc << ": " << a << endl;
	}
	return 0;
}