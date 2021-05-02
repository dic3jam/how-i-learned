#include <iostream>

#include <vector>
#include <stack>
#include <queue>

using namespace std;

int main() {

	vector<int> v;

	for (int i = 1; i <=5; i++) {
		v.push_back(i);	
	}

	for(int i : v) {
		cout << v[i] << " ";
	}

	cout << endl;



	queue<int> q;
	stack<int> s;

	for(int i = 0; i<5; i++) {
		q.push(i);
		s.push(i);
	}

	cout << "Queue ";
	
	while(!q.empty()) {
		int value = q.front();
		q.pop();	
		cout << value << " ";
	}

	cout << endl;

	cout << "Stack ";

	while(!s.empty()) {
		int value = s.top();
		s.pop();
		cout << value << " ";
	}

	cout << endl;

	return 0;
}
