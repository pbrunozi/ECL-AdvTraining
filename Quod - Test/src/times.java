import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class times {
	public static void main(String[] args) {
		// Leitura do arquivo de input no formato de um numero inteiro por linha, sendo que:
		// linha 1 : n, numero de times da temporada anteior
		// linha 2 a linha (1+n) : saldo de gols de cada time na temporada anterior
		// linha (2+n) : k, tamanho do sub-grupo de times que será determinado com valor mais proximo de saldo de gols
		String caminho = "C:/temp/dados1.txt";
		Integer k; // Numero de elemento do sub-grupo de times que serão escolhidos pelo saldo de gols
		
		try { BufferedReader br = new BufferedReader(new FileReader(caminho));
		  String linha = br.readLine();
		  // Leitura do numero time de futebol da temporada anterior
		  Integer n = Integer.parseInt(linha);
		  System.out.println("N="+n+"\n");
		  // Inicializando vetor de saldo de Gols da temporada anterior com todos os n times participantes
		  int Gols[] = new int[n];
		  int i = 0;
		  for (i = 0; i < n; i++)
			  Gols[i] = 0;
		  linha = br.readLine();
		  i = 0;
		  // Leitura dos gols de cada time do n times de futebol
		  while ((linha != null) && (i < n)) {
			  Gols[i] = Integer.parseInt(linha);
			  System.out.println("Gol "+Gols[i]+"\n");
			  i++;
			  linha = br.readLine();
		  }
		  // Leitura do numero (tamanho) do sub-group de k times mais equilibrados em saldo de gols,
		  k = Integer.parseInt(linha);
		  System.out.println("K="+k+"\n");
		  // Ordenação (crescente) dos times de acordo com saldo de gols na temporada anterior
		  Arrays.sort(Gols);
		  for (int valor:Gols)
			  System.out.print(valor+" ");
		  // Determinar o sub-grupo de k times com saldo de gols mais proximos
          // considerando maior saldo de gols. 
		  // Sub-grupo é determinado pela posição do primeiro elemento do sub-grupo de k times no vetor Gols (saldo de gols)
		  int min, max; // valores maximo e minimo de saldo de gols por sub-grupo
		  int index=0;  // Iniciando indice do sub-grupo 
	      int dif=100;  // Iniciando diferença de saldo de gols como 100
		  for(i = 0; i < n-k+1; i++) {
			  min = Gols[i];
			  max = Gols[i];
			  //dif = 100;
			  //index = 0;
			  for(int j = i+1; j < i+k; j++)
				  if (Gols[j] < min)
					  min = Gols[j];
				  else if (Gols[j] > max)
				      max = Gols[j];
			  System.out.println("\n max="+max+" min="+min);
			  if (max-min <= dif) {
				  dif = max - min;
				  index = i;
				  System.out.println("\n index="+index+" dif="+dif);
			  }
		  }
		  System.out.println("\n"+index);
		  System.out.println("\n Sub-Grupo de "+k+" times sscolhido com o seguinte saldo de gols: ");
		  for (i = index; i < index+k; i++) {
			  System.out.print(Gols[i]+" ");
		  }
			  
		}
	    catch (IOException e) {
		System.out.println("Error: "+e.getMessage());
	}
 
		
	}
}
