#include <bits/stdc++.h>

using namespace std;

int main() {
	int t, n;
	cin >> t;
	for(int tc = 1; tc <= t; tc++) {
		cin >> n;
		int a[n];
		for(int i = 0; i < n; i++) {
			cin >> a[i];
		}
		int previousRecord = 0;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			bool greaterThanPrev = (i == 0 || a[i] > previousRecord);
			bool greaterThanNext = (i == n - 1 || a[i] > a[i + 1]);
			if(greaterThanNext && greaterThanPrev) {
				ans++;
			}
			previousRecord = max(previousRecord, a[i]);
		}
		cout << "Case #" << tc << ": " << ans << endl;
	}
	return 0;
}