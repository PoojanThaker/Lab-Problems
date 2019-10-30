#include<bits/stdc++.h>
#define FILE freopen("output.txt","r",stdin);freopen("pout.txt","w",stdout);
#define pii pair<int,int>
using namespace std;


vector<int> BFS(int start,vector<int>*adj,int n)
{
	vector<int> dist(n+1);
	for(int i=0;i<=n;i++)dist[i]=INT_MAX;
	dist[start]=0;
	queue<int> q;
	q.push(start);
	while(!q.empty())
	{
		int tt = q.front();
		q.pop();
		for(auto x:adj[tt])
		{
			if(dist[x]>dist[tt]+1)
			{
				dist[x]=dist[tt]+1;
				q.push(x);
			}
		}
	}
	return dist;
}

int main()
{
	// FILE;
	int t;
	cin>>t;
	while(t--)
	{
		int n,m,j,k;
		cin>>n>>m>>j>>k;
		vector<int> adj[n+1];
		for(int i=0;i<m;i++)
		{
			int x,y;
			cin>>x>>y;
			adj[x].push_back(y);
			adj[y].push_back(x);
		}
		set<int> blacks;
		for(int i=0;i<j;i++)
		{
			int x;
			cin>>x;
			blacks.insert(x);
		}
		vector<vector<int>> ds;
		for(auto x:blacks)
		{
			ds.push_back(BFS(x,adj,n));
		}
		vector<int> ans;
		for(int i=1;i<=n;i++)
		{
			if(blacks.find(i)==blacks.end())
			{
			bool flag=true;
			for(int j=0;j<ds.size();j++)
			{
				if(ds[j][i]>k)flag=false;
			}
			if(flag)ans.push_back(i);
			}
		}

		if(ans.empty())cout<<0<<endl;
		else {cout<<ans.size()<<endl;
			for(auto x:ans)cout<<x<<" ";
				cout<<endl;
		}
	}
}