import java.util.*;
public class main{
	
	static Scanner input = new Scanner(System.in);
	
	static String [] itemCategory = new String [0];
	static String [][] supplier = new String [0][2];
	static String [][] item = new String[0][6];
	
	
	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
		if (os.equals("Linux")) {
		System.out.print("\033\143");
		} else if (os.equals("Windows")) {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		}
		} catch (final Exception e) {
//handle the exception
		System.err.println(e.getMessage());
		}
	}
	
	
	
	
	static String iname = "Admin";
	static String password = "1234";
	
	public static void main(String args[]){///////////////////////////////////////Main////////////////////////////////////////////////////////////////
		
		
		loginPage();
		
	}
	
	public static void loginPage(){
	clearConsole();
	
	System.out.println("\t\t+======================================================+"); 
	System.out.println("\t\t|                     LOGIN PAGE                       |");
	System.out.println("\t\t+======================================================+");
	
		boolean one = false;
		boolean two = false;
		
	do{
		System.out.print(" \n User name : ");
		String name = new Scanner(System.in).nextLine();
			
		if(name.equals(iname)){
			do{ 
					System.out.print(" password : ");
					String pswd = new Scanner(System.in).nextLine();
					
					if(pswd.equals(password)){
						homePage();
					}else{
							two = true;
							System.out.print("incorrect password. try again!");
					}
				}while(two);
			}else{
				one = true;
			System.out.print("incorrect user name...! try again!");
		}
			}while(one);
	}	
	public static void homePage(){/////////////////////////////////////////// home page////////////////////////////////////////////////
		
		clearConsole();
 
		System.out.println("\t\t +===========================================================+ ");
	    System.out.println("\t\t |           WELCOME TO IJSE STOCK MANAGMENT SYSTEM          | ");
	    System.out.println("\t\t +===========================================================+ ");
	    System.out.println();
	    
	        System.out.println("\n [1] Change the Credentials       [2] Supplier Manage ");
            System.out.println(" [3] Stock Manage                 [4] Log out");
            System.out.println(" [5] Eixt the system ");
            System.out.println();
            
            boolean x = false;
            
            do{
				
			Scanner input=new Scanner(System.in);
            System.out.print(" Enter your option : ");
            String option = input.next();
           
           switch (option){
			   case "1": 
					ChangeTheCredentials();
					break;
			   case	"2":
				    SupplierManage();
				    break;
			   case "3":
					StockManage();
					break;
			   case "4":
					LogOut();
					break;
			   case "5":
			   System.exit(0);
					break;
			   default :
					x = true;
					System.out.println("invalid option! ");
			   
			  }
		   }while(x);
		 }  
		public static boolean ChangeTheCredentials(){
			
			clearConsole();
			
			
	    System.out.println("\t\t +-----------------------------------------------------------+");
	    System.out.println("\t\t               Change  The  Credentials                       ");
	    System.out.println("\t\t +-----------------------------------------------------------+");
		
		System.out.println();	
		
			while(true){
				
				System.out.print("Enter the User name to verify it's you : ");
				String name = new Scanner(System.in).nextLine();
				
					if(name.equals(iname)){
						System.out.print("Hey " + iname);
						System.out.println();
						while(true){
							System.out.print("Enter your current password : ");
							String psswrd = new Scanner(System.in).nextLine();
							if(psswrd.equals(password)){
								
								System.out.print("Enter new password : ");
								String password1 = new Scanner(System.in).nextLine();  
								 password = password1;
								 
								 
								 System.out.println();
								 System.out.print("\n Password Changed Successfully! ");
								 System.out.print("Do you want To Go To Main Menu (Y/N): ");
							char a = new Scanner(System.in).next().charAt(0);
							if(a == 'y' || a == 'Y'){
								clearConsole();
								homePage();
								return (true);
								}else if(a == 'N' || a == 'n'){
								clearConsole();
								ChangeTheCredentials();
							    }
							}else{
							System.out.println("Password is incorrect. Please try again!\n");
							}
						}
					}else{
						System.out.println("user name is incorrect. Please try again!\n");
					}
				
			   }
		
		}
		public static void SupplierManage(){
			clearConsole();
		System.out.println("\t\t +-----------------------------------------------------------+");
	    System.out.println("\t\t                        Supplier  Manage                      ");
	    System.out.println("\t\t +-----------------------------------------------------------+");
			
		System.out.println("\n\n");	
		
		System.out.println("[1]. Add Supplier                                   [2]. Update Suplier");
		System.out.println();
		System.out.println("[3]. Delete Suplier                                 [4]. View Suppliers ");
		System.out.println();
		System.out.println("[5]. Search Suplliers                               [6]. Home Page");
		System.out.println("\n\n");
		boolean x = false;
		 do{
			Scanner input=new Scanner(System.in);
            System.out.print(" Enter your option : ");
            String option = input.next();
           
           switch (option){
			   case "1":
			        AddSupplier();
					
					break;
			   case	"2":
			        UpdateSuplier();
				   
				    break;
			   case "3":
					DeleteSuplier();
					break;
			   case "4":
					ViewSuppliers();
					break;
			   case "5":
			        SearchSuplliers(); 
					break;
				case  "6":
					homePage();
					break;
			   default :
					x = true;
					System.out.println("invalid option! ");
			   
			  }
		   }while(x);
		}
		
		public static void AddSupplier(){
			clearConsole();
			
			System.out.println("+///////////////////////////// Add Supplier ///////////////////////////+");
			System.out.println();
			
			while(true){
				boolean flag = false;
				
				System.out.print("Supplier Id : ");
				String supId = new Scanner(System.in).nextLine();
				
				for(int i=0;i<supplier.length;i++){
					if(supId.equals(supplier[i][0])){
						flag  = true;
						break;
					}
				}
				if(flag == false){
					System.out.print("Supplier name : ");
					String supName = new Scanner(System.in).nextLine();
					
					supplier=grow(supplier,2);
					
					supplier[supplier.length -1][0] = supId;
				    supplier[supplier.length -1][1] = supName;
				    
				    System.out.print("Added successfully ! Do you want to add another supplier(Y/N)?  ");
					char op = new Scanner(System.in).next().charAt(0);
					if(op == 'n' || op == 'N'){
						clearConsole();
						SupplierManage();
						}else if(op == 'y'||op == 'Y'){
							System.out.println();
							clearConsole();
							AddSupplier();
					    }
					}else{
					System.out.print("already exists. try another supplier id!\n");					
				    }
			    }
		}
	
		public static String[][] grow(String[][] ar,int x){
			
			String [][] temp = new String [ar.length + 1][x];
			for (int i = 0; i < ar.length; i++) {
				temp[i]=ar[i];
			}
		return temp;
		}
		public static void UpdateSuplier(){  
			clearConsole();
			System.out.print("+///////////////////////-Update  Suplier///////////////////////////+");
			System.out.println();
			
			while(true){
				System.out.println("Enter supplier Id : ");
				String supId = new Scanner(System.in).nextLine();
				System.out.println();
				
			for(int i=0;i<supplier.length; i++){
				if(supId.equals(supplier[i][0])){
					System.out.println("Supplier Name : " + supplier[i][1]);
					System.out.print("Enter the new supplier name: ");
					String supName = new Scanner(System.in).nextLine();
					supplier[i][1] = supName;
					
					System.out.println();
					System.out.print("update successfully! Do you want to add another supplier(Y/N)? ");
					
					char op= new Scanner(System.in).next().charAt(0);
					if(op=='n'||op=='N'){
						clearConsole();
						SupplierManage();
					}else if(op=='y'||op=='Y'){
						System.out.println();
					}	
			    }
			}
			System.out.println("can't find supplier id.try again !");
		  }
		}
		public static void DeleteSuplier(){
			clearConsole();
			
			System.out.println("+///////////////////////// Delete  Suplier /////////////////////////+");
			System.out.println();
							
			
                    while (true) {
                        System.out.print("Enter Supplier ID : ");
                        String id = new Scanner(System.in).nextLine();
                        int check = 0;
                        for (int i = 0; i < supplier.length; i++) {
                            if (id.equals(supplier[i][0])) {
                                check = 1;
                                supplier = deleteSupplier(supplier, i);
                                System.out.println("Supplier has been deleted successfully");
                                System.out.print("Do you want to delete another student? (y/n) ");
                               char op= new Scanner(System.in).next().charAt(0);
									if(op=='n'||op=='N'){
									clearConsole();
									SupplierManage();
									
									}else if(op=='y'||op=='Y'){
									System.out.println();
								}	
										   
                            }
                        }
                       
                    }
	    }
	    
	public static String[][] deleteSupplier(String[][] supplier, int id) {
        String[][] temp = new String[supplier.length - 1][2];
        int k = 0;
        for (int i = 0; i < supplier.length; i++) {
            if (id == i) {
                continue;
            }
            temp[k][0] = supplier[i][0];
            temp[k][1] = supplier[i][1];
            k++;
        }
        return temp;
         
    }
	public static void ViewSuppliers(){
		
		 clearConsole();
	System.out.println("+///////////////////////// View  Suplier /////////////////////////+");
			System.out.println();
		System.out.println("+--------------------------------------+");
        System.out.println("| Supplier ID  |     Supplier Name     |");
        System.out.println("+--------------------------------------+");

			for (String[] strings : supplier){
				System.out.printf("|   %-10s |      %-16s |%n", strings[0], strings[1]);
			}
        System.out.println("+--------------------------------------+");
        System.out.print(" Do you want to view again (Y/N) ? ");
					
					char op=input.next().charAt(0);
					if(op=='n'||op=='N'){
						SupplierManage();
					}else if(op=='y'||op=='Y'){
						ViewSuppliers();
						System.out.println();
					}
	}	
	public static void SearchSuplliers(){
		clearConsole();
		Scanner input = new Scanner(System.in); 
		System.out.println(" //////////////////////////// SEARCH SUPPLIERS///////////////////////////");
		
		
		System.out.println();
		
		while(true){
			System.out.print("Supplier ID : ");
			String supId=input.next();
			
			for (int i = 0; i < supplier.length; i++){
				if(supId.equals(supplier[i][0])){
					System.out.println("Supplier Name  : " +supplier[i][1]);
					
					System.out.print("added successfully! Do you want to add another find(Y/N)? ");
					
					char op=input.next().charAt(0);
					if(op=='n'||op=='N'){
						SupplierManage();
					}else if(op=='y'||op=='Y'){
						System.out.println();
					}
				}
			}System.out.print("can't find supplier id.try again !\n");
		}
		
	}
		public static void StockManage() {
    clearConsole();
    System.out.println("\t\t +===========================================================+");
    System.out.println("\t\t                     Stock  Manage                            ");
    System.out.println("\t\t +===========================================================+");

    System.out.println("\n\n");

    System.out.println("[1]. Manage Item Categories                         [2]. Add Item");
    System.out.println();
    System.out.println("[3]. Get Item Supplier                              [4]. View Items ");
    System.out.println();
    System.out.println("[5]. Rank Items Per Unit Price                      [6]. Home Page");
    System.out.println("\n\n");

    boolean x = false;

    do {
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter your option : ");
        String option = input.next();

        switch (option) {
            case "1":
                ManageItemCategories();
                break;
            case "2":
                AddItem();
                break;
            case "3":
                GetItemSupplier();
                break;
            case "4":
                ViewItems();
                break;
            case "5":
                RankItemsPerUnitPrice();
                break;
            case "6":
                homePage();
                break;
            default:
                x = true;
                System.out.println("Invalid option! ");
        }
    } while (x);
}

	public static void ManageItemCategories() {
		clearConsole();
		System.out.println("+///////////////////////// Manage  Item  Catogaries /////////////////////////+");
		System.out.println();
		
    System.out.println("[1]. Add New Item Category                         [2]. Delete Item Categary");
    System.out.println();
    System.out.println("[3]. Update Item                               [4]. Stock Management ");
    System.out.println();
		
		boolean x = false;

    do {
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter your option : ");
        String option = input.next();

        switch (option) {
            case "1":
                AddNewItemCategory();
                break;
            case "2":
                DeleteItemCategary();
                break;
            case "3":
                UpdateItemCategary();
                break;
            case "4":
                StockManage();
                break;
           
            default:
               // x = true;
                System.out.println("Invalid option! ");
        }
    } while (x);
			
	}
	public static void AddNewItemCategory(){
		clearConsole();
		Scanner input = new Scanner(System.in);
		System.out.println("+///////////////////////// Add New Item Category /////////////////////////+");
		System.out.println();
		
	
		
		while(true){
			boolean flag = false;
			
			System.out.print("Enter the new Item Category: ");
			String itemCatName = input.next();
			
			for (int i = 0; i < itemCategory.length; i++){
				if(itemCatName.equals(itemCategory[i])){
					flag = true;
					break;
				}
			}
			
			if(flag == false){
				growItemCategory();
				
				itemCategory[itemCategory.length-1] = itemCatName;
				System.out.print("added successfully! Do you want to add another category(Y/N)? ");
				
				char op=input.next().charAt(0);
					if(op=='n'||op=='N'){
						ManageItemCategories();
					}else if(op=='y'||op=='Y'){
						System.out.println();
					}
			}else{
			System.out.print("already exists. try another Item category!\n");
			}
		}
		
		}
	public static void growItemCategory(){
		
	String [] temp = new String [itemCategory.length + 1];
			for (int i = 0; i < itemCategory.length; i++) {
				temp[i]=itemCategory[i];
			}
			
		itemCategory=temp;
	}
	
	public static void DeleteItemCategary(){
		
		Scanner input = new Scanner(System.in);
		clearConsole();
		
		System.out.println("+///////////////////////// Delete Item Categary /////////////////////////+");
		System.out.println();
		System.out.println();
		
		while(true){
			System.out.print("Item Category : ");
			String itemCatName = input.next();
			
			for (int i = 0; i < itemCategory.length; i++){
				if(itemCatName.equals(itemCategory[i])){
					itemCategory[i] = null;
					
					for (int k=0,j=0; j < itemCategory.length-1 ; j++){
						if(itemCategory[j] == null){j++;}
						itemCategory[k] = itemCategory[j];
						k++;
					}
					
					String [] newArray = Arrays.copyOfRange(itemCategory, 0, itemCategory.length-1);
					itemCategory = newArray;
					
					System.out.print("deleted successfully! Do you want to delete another?(Y/N)  ");
					
					char ch = input.next().charAt(0);
					if(ch == 'n' || ch == 'N'){
						 StockManage();
					}else if(ch == 'y' || ch == 'Y'){
						System.out.println();
					}
				}
			}
			System.out.println("can't find Item Category. Try again !");
		}
	}
  
	
	public static void UpdateItemCategary(){
		
		clearConsole();
		
		System.out.println("+///////////////////////// Update Item Categary /////////////////////////+");
		System.out.println();
		
			while(true){
				System.out.println("Enter Item Category: ");
				String newitemscat = new Scanner(System.in).nextLine();
				
				System.out.println();
				
			for(int i=0;i<itemCategory.length; i++){
				if(newitemscat.equals(itemCategory[i])){
					
					System.out.println("Enter the new Item : ");
					String newitem = new Scanner(System.in).nextLine();
					
					itemCategory[i] = newitemscat;
					
					System.out.println();
					System.out.print("update successfully! Do you want to add another item (Y/N)? : ");
					
					char op= new Scanner(System.in).next().charAt(0);
					if(op=='n'||op=='N'){
						clearConsole();
						ManageItemCategories();
					}else if(op=='y'||op=='Y'){
						System.out.println();
					}	
			    }
			}
			System.out.println("can't find supplier id.try again !");
		  }
		
		}
	
	
	public static void AddItem() {
		
		clearConsole();
		Scanner input = new Scanner(System.in);
		System.out.println("+///////////////////////// AddItem /////////////////////////+");
		System.out.println();
		
		if(itemCategory.length<1){
			System.out.println("OOPS! It seems that don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) : ");
			String option = input.next();
			
			while(!(option.equals("Y") || option.equals("y") || option.equals("N") || option.equals("n"))){
				
				System.out.println("OOPS! wrong option");
				System.out.print("Do you want to add a new item category?(Y/N) : ");
				option = input.next();
			} 
			
			if(option.equals("Y") || option.equals("y")){
				clearConsole();
				
				AddNewItemCategory();
			} else {
				clearConsole();
				StockManage();
			}
		}
		if(supplier.length<1){
			System.out.println("OOPS! It seems that don't have any item suppliers in the system.");
			System.out.print("Do you want to add a new item supplier?(Y/N) : ");
			String option = input.next();
			
			while(!(option.equals("Y") || option.equals("y") || option.equals("N") || option.equals("n"))){
				System.out.println("OOPS! wrong option");
				System.out.print("Do you want to add a new supplier?(Y/N) : ");
				option = input.next();
			}
			if(option.equals("Y") || option.equals("y")){
				clearConsole();
				AddSupplier();
			} else {
				clearConsole();
				StockManage();
			}
		}
		
		item = grow(item,6);
		System.out.print("Item Code\t: ");
		String itemcode = input.next();
		
		for (int i = 0; i < item.length; i++) {
            if (item[i][1] != null && item[i][1].equals(itemcode)) {
                System.out.println("Item code already exists. Try another Code.");
                System.out.print("Item Code\t: ");
                itemcode = input.next();
                i = -1; // re-loop 
            }
        } 
        for (int i = 0; i < item.length; i++) {
           if (item[i][1] == null) {
                item[i][1] = itemcode;		// itemcode asign (1 = item code)
                break;
            }
        }
        
		
		System.out.println("\nSuppliers list:");
		System.out.printf("+--------------+--------------+----------------+%n");
        System.out.printf("|%6s   %6s %12s |%14s  |%n","#","|","SUPPLIER ID","SUPPLIER NAME");
        System.out.printf("+--------------+--------------+----------------+%n");
        for(int i =0; i<supplier.length; i++){
			System.out.printf("|%6s   %6s %12s |%14s  |%n",(i+1),"|",supplier[i][0],supplier[i][1]);
		}
		System.out.printf("+--------------+--------------+----------------+%n");
		
		int inputSupNum = foundSuppliernum();
		
		
		for (int i = 0; i < item.length; i++) {
           if (item[i][1] == itemcode) {
                item[i][0] = supplier[inputSupNum-1][0];		// Supplier id asign (0 = supplier Id)
                break;
            }
        }
        System.out.println("\nItem Categories:");
        System.out.printf("+--------------+----------------+%n");
        System.out.printf("|%8s  %5S  %12s |%n","#","|","CATEGORY NAME");
        System.out.printf("+--------------+----------------+%n");
        for(int i =0; i<itemCategory.length;i++){
			System.out.printf("|%8s  %5S    %-8s  %3S%n",(i+1),"|",itemCategory[i],"|");
		}
		System.out.printf("+--------------+----------------+%n");
		
		boolean catFound = false;
		int inputCatNum = 0;
		
		do{
			System.out.print("\nEnter the category number > ");
			inputCatNum = input.nextInt();
			
			if(inputCatNum<=itemCategory.length){
				catFound = true;
			}
			 if (catFound==false) {
                System.out.println("OOPS! wrong number. Try again!\n");
            }
		}
		while(catFound==false);
		for (int i = 0; i < item.length; i++) {
           if (item[i][1] == itemcode) {
                item[i][5] = itemCategory[inputCatNum-1];		// category asign (5 = category)
                break;
            }
        }
        
        for(int i =0; i<item.length;i++){
			if (item[i][1] == itemcode) {
				System.out.print("\nDescription : ");
				item[i][2] = input.next();
				
				System.out.print("Unit Price : ");
				item[i][3] = input.next();
				
				System.out.print("Qty on hand : ");
				item[i][4] = input.next();
			}
		}
		
		
		System.out.print("Added successfully! Do you want to add another Item(Y/N)? ");
		String option = input.next();
		
		while(!("Y".equalsIgnoreCase(option) || option.equalsIgnoreCase("n"))){
			System.out.println("OOPS! wrong Input. Try again!\n");
			System.out.print("Added successfully! Do you want to add another Item(Y/N)? ");
			option = input.next();
		}
		if("Y".equalsIgnoreCase(option)){
			AddItem();
			
		} else {
			StockManage();
			
		}
	}
	public static String[][] growItem(String[][] ar,int length){
		
		
		String[][] newArray = new String[ar.length+1][length];
		
		for(int i=0;i<ar.length;i++){
			for(int j=0;j<ar[i].length;j++){
				
				newArray[i][j] = ar[i][j];
				
				
				}
		
			} 
			
			return newArray;
		
	} 
	public static int foundSuppliernum(){
		
		System.out.print("\nEnter the supplier number > ");
        String inputSupStringNum = input.next();

        boolean match = false;
      
        {
			int i =0;
        do{
			String ii = String.valueOf(i);
            if (inputSupStringNum.equals(ii)) {
                match = true;
                break;
            }
            i++;
		} 
		while(i<=supplier.length);	}
		
		
		int num1 =0;
        if (!match) {
            System.out.println("OOPS! wrong number. Try again!\n");
            foundSuppliernum();
        } else {
            num1 = Integer.parseInt(inputSupStringNum);
            
        }
        return num1;
}

	
	
		
	public static void GetItemSupplier() {
		Scanner input = new Scanner(System.in);
		clearConsole();
		System.out.println("+///////////////////////// Get  Item  Supplier /////////////////////////+");
		System.out.println();
		
		
                    for(String[] demo : item){
							System.out.println(Arrays.toString(demo));
					}
			
			 boolean flog01=false;
        while(true){
            boolean flag = false;
            System.out.println();
            System.out.print("Enter Supplier Id : ");
            String supId =input.next();

           

           
            for (int i = 0; i < supplier.length; i++) {
                if (supId.equals(supplier[i][0])){
                    flag = true;
                    System.out.println("Supplier Name : " + supplier[i][1] + "\n\n");
                    
                    
                    
                    
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                    System.out.printf("|     %s    |    %s    |     %s    |     %s   |     %s      |%n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    for (int j = 0; j < item.length; j++){
                        if (supId.equals(item[j][0])){
                            System.out.printf("|    %10s    |    %-10s     |    %10s     |    %10s     |   %10s   |%n", item[j][1], item[j][2], item[j][3], item[j][4], item[j][5]);
                        }
                    }
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                }
            }
            if (!flag) {
                System.out.println("Can't find supplier ID. Try again ✗");
            }
      
           System.out.print("Do you want to view agin?(Y/N)  ");
					
		char ch = input.next().charAt(0);
		if(ch == 'n' || ch == 'N'){
			StockManage();
			
		 }else if(ch == 'y' || ch == 'Y'){
			GetItemSupplier();
		}   
	}
}
	public static void ViewItems(){
		Scanner input = new Scanner(System.in);
		clearConsole();
		System.out.println("+///////////////////////// View  Items /////////////////////////+");
		System.out.println();
		
		System.out.println();
		
		for (int i = 0; i < itemCategory.length; i++){
			System.out.println("\n"+itemCategory[i]+":");
			System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
			System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |%n","SID","CODE","DESC","PRICE","QTY");
			System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
			for (int j = 0; j < item.length; j++){
				System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |%n",item[j][0],item[j][1],item[j][2],item[j][3],item[j][4]);
			}
			System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
	 }
		System.out.print("Do you want to go stock manage page?(Y/N)  ");
					
		char ch = input.next().charAt(0);
		if(ch == 'n' || ch == 'N'){
			StockManage();
			
		 }else if(ch == 'y' || ch == 'Y'){
			System.out.println();
		}
		
	}
	public static void RankItemsPerUnitPrice() {
		Scanner input = new Scanner(System.in);
		clearConsole();
		System.out.println("+///////////////////////// Rank  Items  Per  Unit  Price /////////////////////////+");
		System.out.println();
		
		
		String [][] sortedArray = new String[item.length][6];
		
		for (int i = 0; i < item.length; i++){
            sortedArray[i] = item[i];
        }
        
		for (int i = 0; i < item.length; i++){
			for (int j = 1; j < item.length-1; j++){
				if(Double.parseDouble(sortedArray[j][3])>Double.parseDouble(sortedArray[j+1][3])){
					String [] temp = sortedArray[j];
					sortedArray[j] = sortedArray[j+1];
					sortedArray[j+1] = temp;
				}	
		}
	}
    String[][] temp=new String[item.length][6];
    int demo=sortedArray.length-1;
    for (int i = 0; i < sortedArray.length; i++) {
    
        temp[i]=sortedArray[demo];
        demo--;
    }
		
		System.out.println();
		System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
		System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |        %s        |%n","SID","CODE","DESC","PRICE","QTY","CAT");
		System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
		
				for (int i = 0; i < sortedArray.length; i++){
					System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |    %10s     |%n",temp[i][0],temp[i][1],temp[i][2],Double.parseDouble(temp[i][3]),temp[i][4],temp[i][5]);
				}
					System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
		
					System.out.print("Do you want to go stock manage page?(Y/N)  ");
				
		char ch = input.next().charAt(0);
			if(ch == 'n' || ch == 'N'){
				StockManage();
			}else if(ch == 'y' || ch == 'Y'){
				System.out.println();
			}	
	}
	
	public static void LogOut(){
			clearConsole();
			loginPage();
			
	}
}
