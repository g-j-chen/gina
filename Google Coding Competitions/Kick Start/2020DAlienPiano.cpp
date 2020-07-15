#include <bits/stdc++.h>

using namespace std;

int main() {
	int t;
	cin >> t;
	for(int tc = 1; tc <= t; tc++) {
		int k;
		cin >> k;
		int a[k];
		for(int i = 0; i < k; i++) {
			cin >> a[i];
		}
		int ans = 0;
		int up = 0;
		int down = 0;
		for(int i = 1; i < k; i++) {
			if(a[i] > a[i - 1]) {
				up++;
				down = 0;
			} else if(a[i] < a[i - 1]) {
				down++;
				up = 0;
			}
			if(up > 3 || down > 3) {
				ans++;
				up = down = 0;
			}
		}
		cout << "Case #" << tc << ": " << ans << endl;
	}
	return 0;
}