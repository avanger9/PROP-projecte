package Domini;
import java.util.*;
public class Tauler_quadrat extends Tauler{
	public Tauler_quadrat makeCopy() {
		Tauler_quadrat t=new Tauler_quadrat();
		t.g=new Graph(g);
		t.mat=new Node[mat.length][mat[0].length];
		for (int i=0;i<mat.length;++i) 
			System.arraycopy(mat[i],0,t.mat[i],0,mat[i].length);
		t.impepinables=new HashSet<Integer>(impepinables);
		t.nums_existents=new HashSet<Integer>(nums_existents);
		t.vec=new Node[vec.length];
		System.arraycopy(vec,0,t.vec,0,vec.length);
		t.max=max;
		return t;
	}
	public void crea_graf() {
		g=new Graph(mat.length*mat[0].length);
		for (int i=0;i<mat.length;++i) {
			for (int j=0;j<mat[i].length;++j) {
				if (j-1>=0) g.afegir_adjacencia(mat[i][j],mat[i][j-1]);
				if (j+1<mat[i].length) g.afegir_adjacencia(mat[i][j],mat[i][j+1]);
				if (i-1>=0) g.afegir_adjacencia(mat[i][j],mat[i-1][j]);
				if (i+1<mat.length) g.afegir_adjacencia(mat[i][j],mat[i+1][j]);				
			}
		}
	}
}
