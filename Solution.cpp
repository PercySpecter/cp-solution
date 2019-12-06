#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n;
	cin >> n;
	vector<int> v(n);
	int i;
	for(i=0;i<n;i++)
	{
		cin >> v[i];
	}
	for(auto x:v)
	{
		cout << x << endl;
		
	}
	return 0;
}