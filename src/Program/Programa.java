package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.Funcionario;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner (System.in);
       
    
       List<Funcionario> list = new ArrayList<>();
       
       System.out.println("Digite quantos funcionarios serão cadastrados");
       int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Funcionario #" + i + ": ");
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Este Id ja existe tente novamente: ");
				id = sc.nextInt();
	       }
	
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			list.add(new Funcionario(id, nome, salario));
          }
		// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:
		
				System.out.println();
				System.out.print("Insira o ID do funcionário que terá aumento salarial: ");
				int id = sc.nextInt();
				Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
				if (emp == null) {
					System.out.println("Este id não existe!");
				}
				else {
					System.out.print("Digite a porcentagem: ");
					double percentagem = sc.nextDouble();
					emp.increaseSalario(percentagem);
					}
				// PART 3 - LISTING EMPLOYEES:
				
				System.out.println();
				System.out.println("List de Funcionarios:");
				for (Funcionario obj : list) {
					System.out.println(obj);
				}
						
				sc.close(); 
	}

	private static boolean hasId(List<Funcionario> list, int id) {
		
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp !=null;
	}
	
	}	