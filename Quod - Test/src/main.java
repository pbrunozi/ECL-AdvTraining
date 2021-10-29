import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class main {

public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  // Variaveis n e k //
  int n = input.nextInt();
  int k = input.nextInt();
  int Luckmax = 0;
  ArrayList<Integer> importanteConcurso = new ArrayList<>();
  //////////////////////
  
//Criar Lista de concursos importante
  for(int i = 0; i < n; i++){
      int sorte = input.nextInt();
      int importante = input.nextInt();
      
      if(importante != 1)
      {
          Luckmax += sorte;
      } 
          
      else
          importanteConcurso.add(sorte);
  }

//Sort the important contests in descending order
  Collections.sort(importanteConcurso, Collections.reverseOrder());
  
//Perde os k concursos importante e ganha o resto concursos menos importantes
  for(int i = 0; i < importanteConcurso.size(); i++){
	  
      if(i < k)
          Luckmax += importanteConcurso.get(i);            
      else
          Luckmax -= importanteConcurso.get(i);                
  }
  
  System.out.println(Luckmax);

}

	
}
