#include <bits/stdc++.h>

using namespace std;

#define ll long long

const int mxN = 1e5;
int n, a[mxN], c[2 * 100 * mxN + 1];

void solve(int tc) {
	cin >> n;
	int max = 0, min = 0;
	for(int i = 0; i < n; i++) {
		cin >> a[i];
		if(a[i] < 0) {
			min -= a[i];
		} else {
			max += a[i];
		}
	}

	int t = 0;
	ll ans = 0;
	c[min]++;
	for(int i = 0; i < n; i++) {
		t += a[i];
		for(int j = 0; j * j <= max; j++) {
			if(min + (t - j * j) >= 0) {
				ans += c[min + (t - j * j)];
			}
		}
		c[min + t]++;

	}
	cout << "Case #" << tc << ": " << ans << endl;
	memset(c, 0, 4 * (min + max + 1));
}

int main() {
	int t;
	cin >> t;
	for(int tc = 1; tc <= t; tc++) {
		solve(tc);
	}
	return 0;
}