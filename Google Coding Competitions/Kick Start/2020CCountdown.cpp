#include <bits/stdc++.h>

using namespace std;

int main() {
	int t;
	cin >> t;
	for(int tc = 1; tc <= t; tc++) {
		int n, k;
		cin >> n >> k;
		int ans = 0;
		int count = 0;
		int a[n];
		for(int i = 0; i < n; i++) {
			cin >> a[i];
			if(a[i] == (a[i - 1] - 1)) {
				count++;
			} else {
				count = 0;
			}
			if(a[i] == 1 && count >= k - 1) {
				ans++;
			}
		}

		cout << "Case #" << tc << ": " << ans << endl;
	}
	return 0;
}