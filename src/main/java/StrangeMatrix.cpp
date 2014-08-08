#include <iostream>

using namespace std;
int main() {

	int m, n, p, i, j;
	cin >> n >> m >> p;
	int** matrix;
	matrix = new int*[n];

	if (m > 1) {
		for (int k = 0; k < p; ++k) {
			cin >> i >> j;
			i--;
			if (matrix[i] == NULL) {
				matrix[i] = new int[m+2]();
				matrix[i][0] = m-1;
			}
			matrix[i][j] += 1;
		    if (j == 1) {
		        matrix[i][0] -= 1;
		        if (matrix[i][j] - matrix[i][j+1] >= 2)
		            matrix[i][m+1] -= 1;
		    }
		    if (j == m) {
		        matrix[i][0] += 1;
		        if (matrix[i][j-1] - matrix[i][j] >= 1)
		            matrix[i][m+1] += 1;
		    }
		    if (j > 1 and j < m) {
		        if (matrix[i][j] - matrix[i][j+1] >= 2)
		            matrix[i][m+1] -= 1;
		        if (matrix[i][j-1] - matrix[i][j] >= 1)
		            matrix[i][m+1] += 1;
		    }
		}
	}
	for (int i = 0 ; i < n; i++) {
		if (m == 1) 
			cout << 0 << endl;
		else if (matrix[i] == NULL) 
			cout << m-1 << endl;
		else if (matrix[i][m+1] < 0) 
			cout << -1 << endl;
		else
			cout << matrix[i][0] << endl;
	}
	// matrix[0] = new int[m]();
	// matrix[1] = new int[m];
	// matrix[2] = new int[m];
	// if (matrix[3]  == NULL)
	// 	cout << matrix[3] <<endl;
	// return 0;


}