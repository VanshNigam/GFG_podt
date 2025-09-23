/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // add code here.
        if(par[x]==x)return par[x];
        return find(par,par[x]);
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        int x_root = find(par, x);
        int y_root = find(par, z);

        if (x_root == y_root) {
            return;
        }
        else{
            par[x_root]=y_root;
        }
    }
}