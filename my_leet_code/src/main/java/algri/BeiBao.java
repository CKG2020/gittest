package algri;

public class BeiBao {

    public void init(int W[], int V[], int n, int max) {
        int x=n+1;
        int y=max+1;
        int C[][] = new int[x][y];
        for (int i = 0; i <x; i++) {
            C[i][0] = 0;
        }
        for (int j = 0; j <y; j++) {
            C[0][j] = 0;
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j <y; j++) {
                if (W[i - 1] <= j) {
                    if (V[i - 1] + C[i - 1][j - W[i - 1]] > C[i - 1][j]) {
                        C[i][j] = V[i-1] + C[i - 1][j - W[i - 1]];
                    } else
                        C[i][j] = C[i - 1][j];
                }

                else{
                    C[i][j]=C[i-1][j];
                }
            }
        }

        for (int i = 0; i < x; i++) {
            System.out.println();
            for (int j = 0; j < y; j++) {
                System.out.print(C[i][j]);
            }

        }

    }

    public static void main(String[] args) {
        BeiBao beiBao = new BeiBao();
//        beiBao.init();
        int w[]={2,3,4,5};
        int v[]={3,4,5,6};
        beiBao.init(w,v,4,5);
    }


}
