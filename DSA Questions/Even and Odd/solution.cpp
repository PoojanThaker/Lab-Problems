#include <bits/stdc++.h>
#define mid (tl+tr)/2
#define mod 1000000007
#define fain(arr) for(int i=0;i<n;i++)cin>>arr[i];
#define faio(arr) for(int i=0;i<n;i++)cout<<arr[i]<<" ";
#define all(x) x.begin(),x.end()
#define SPEED ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define bugv(n1) if(DEBUG)cout<<#n1<<" is "<<n1<<'\n';
#define FILE freopen("tin.txt","r",stdin);freopen("tout.txt","w",stdout);
#define rep(i, begin, end) for (__typeof(end) i = (begin) - ((begin) > (end)); i != (end) - ((begin) > (end)); i += 1 - 2 * ((begin) > (end)))
#define endl '\n'
#define ll long long int
#define pii pair<int,int>
#define pll pair<long long int,long long int>
#define pi acos(-1)
#define sz(x) ((int)x.size())
#define clr(x) memset(x, 0, sizeof(x))
#define init(x, a) memset(x, a, sizeof(x))
#define DEBUG true
using namespace std;

vector<int> ans;

void DFS(int current,bool*visited,vector<int>*adj,bool flag)
{
	if(visited[current])return;

	visited[current]=true;
	ans.push_back(current);
	vector<int> pp;
	for(auto x:adj[current])
	{
		pp.push_back(x);
	}

	if(!flag)
	{
		sort(all(pp));
	}
	else
	{
		sort(all(pp),greater<int>());
	}

	for(auto x:pp)
	{
		if(!visited[x])
		{
			DFS(x,visited,adj,!flag);
		}
	}
}



int main() {
  // FILE;
  // SPEED;
  
  int n,m;
  cin>>n>>m;

  vector<int> adj[n+1];

  for(int i=0;i<m;i++)
  {
  	int x,y;
  	cin>>x>>y;
  	adj[x].push_back(y);
  	adj[y].push_back(x);
  } 

  bool visited[n+1];
  for(int i=0;i<=n;i++)visited[i]=false;
  DFS(1,visited,adj,true);
  for(auto x:ans)
  {
  	cout<<x<<" ";
  }

  

}