importjava.io.BufferedReader;
importjava.io.DataInputStream;
importjava.io.DataOutputStream;
importjava.io.EOFException;
importjava.io.File;
importjava.io.FileOutputStream;
importjava.io.InputStreamReader;
importjava.net.Socket;
importjava.util.Scanner;

class Client
{  
	public static void main(String args[])throws Exception{  
	String address = "";
	Scanner sc=new Scanner(System.in);
	System.out.println (" ------------------------------------------------------------------------------------------------------------------------");
	System.out.println ("                                                    FILE TRANSFER");
	System.out.println (" ------------------------------------------------------------------------------------------------------------------------");
	System.out.println ("                                         This is the Client side of the program...");
	System.out.println ("                                          ________________________________________");

	System.out.println("                                         |Enter Server Address:                   |");

	System.out.print ("                                         |");
	address=sc.nextLine();
//create the socket on port 5000
	Socket s=new Socket(address,5000);  
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStreamdout=new DataOutputStream(s.getOutputStream());  
	BufferedReaderbr=new BufferedReader(new InputStreamReader(System.in));  
	System.out.println ("                                         |________________________________________|");

	System.out.println("                                         |Enter start to receive the file:        |");

	System.out.print ("                                         |");
	String str="",filename="";  
	try
		{
		while(!str.equals("start"))
		str=br.readLine(); 

		dout.writeUTF(str); 
		dout.flush();  
	
		filename=din.readUTF(); 
		System.out.println ("                                         |________________________________________|");
	
		System.out.println("                                         |Receving file from Server: "+filename);
		System.out.println ("                                         |________________________________________|");

		filename="client"+filename;
		System.out.println("                                         |Saving the sent file as: "+filename);
		System.out.println ("                                         |________________________________________|");

		longsz=Long.parseLong(din.readUTF());

		System.out.println ("                                         |Size of file: "+sz+" MB");
		System.out.println ("                                         |________________________________________|");

		byte b[]=new byte [1024];
		System.out.println("                                         |Receving file from server..             |");

	FileOutputStreamfos=new FileOutputStream(new File(filename),true);
	longbytesRead;
	do
		{
			bytesRead = din.read(b, 0, b.length);
			fos.write(b,0,b.length);
		}
	while(!(bytesRead<1024));
	System.out.println("                                         |File received......                     |");
	System.out.println ("                                         |________________________________________|");

	System.out.println("                                         |File transfer Comleted!!!               |");
	System.out.println ("                                         |________________________________________|");

	dout.close();  	
	s.close();  
	}
catch(EOFException e)
{
	//do nothing
}
}
}  
//this is a typical client program
