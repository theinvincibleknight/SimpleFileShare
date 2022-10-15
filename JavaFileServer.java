//package Server;

importjava.io.DataInputStream;
importjava.io.DataOutputStream;
importjava.io.File;
importjava.io.FileInputStream;
import java.net.ServerSocket;
importjava.net.Socket;
importjava.util.Scanner;

class Server
	{  
		public static void main(String args[])throws Exception{   
		String filename;
		System.out.println (" ------------------------------------------------------------------------------------------------------------------------");
	System.out.println ("                                                    FILE TRANSFER");
		System.out.println (" ------------------------------------------------------------------------------------------------------------------------");
		System.out.println ("                                         This is the Server side of the program...");
		System.out.println ("                                          __________________________________________");
		System.out.println("                                         |Enter the  File Name:                     |");
		System.out.print ("                                         |");
		Scanner sc=new Scanner(System.in);
		filename=sc.nextLine();
		
		System.out.println ("                                         |__________________________________________|");
		sc.close();
	while(true)
	{
		//create server socket on port 5000
		ServerSocketss=new ServerSocket(5000); 

		System.out.println ("                                         |server is Waiting for request             |");
		System.out.println ("                                         |__________________________________________|");
		Socket s=ss.accept();  
		System.out.println ("                                         |Connected With IP adress"+s.getInetAddress().toString());
		System.out.println ("                                         |__________________________________________|");
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStreamdout=new DataOutputStream(s.getOutputStream());  
	try
		{
			String str="";  

			str=din.readUTF();


	if(!str.equals("stop"))
	{  

		System.out.println("                                         |Sending File from Server : "+filename);
		dout.writeUTF(filename);  
		dout.flush();  

		File f=new File(filename);
		FileInputStream fin=new FileInputStream(f);
		longsz=(int) f.length();

		byte b[]=new byte [1024];

		int read;

		dout.writeUTF(Long.toString(sz)); 
		dout.flush(); 
		System.out.println ("                                         |__________________________________________|");
		System.out.println ("                                         |Size of file: "+sz+" MB");

		System.out.println ("                                         |__________________________________________|");
		System.out.println ("                                         |Buffer size: "+ss.getReceiveBufferSize());
		System.out.println ("                                         |__________________________________________|");
	while((read = fin.read(b)) != -1)
		{
		dout.write(b, 0, read); 
		dout.flush(); 
		}
		fin.close();

		System.out.println("                                         |On the process...                         |"); 
		dout.flush(); 
	}  
dout.writeUTF("stop"); 
System.out.println ("                                         |__________________________________________|");
System.out.println("                                         |Sending file Completed                    |");
System.out.println ("                                         |__________________________________________|");
dout.flush();  
}
	catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("An error occured.....");
		}
din.close();  
s.close();  
ss.close();  
}
}
}
