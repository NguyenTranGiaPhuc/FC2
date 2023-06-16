package kiemtra_fc2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	Node head;
	
	Scanner sc = new Scanner(System.in);
	
	void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
	
	void doc_file() {
        String filePath = "D:\\Homework_FC1\\src\\P8207\\D3\\kiemtra_fc2\\src\\kiemtra_fc2\\solieu.txt\\";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int n = Integer.parseInt(scanner.nextLine());
            String[] numbers = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(numbers[i]);
                addNode(value);
            }

            scanner.close();
        } catch (Exception e ) {
            System.out.println("File not found.");
        }
    }
	
	void nhapds() {
		int x;
		Node cuoi = null;
		while(true) {
			System.out.println("Nhap x=");
			x = sc.nextInt(); 
			if(x==0)
				break;
			Node t= new Node(x);
			if(head == null) 
				head = cuoi = t;
			else {
				cuoi.next = t;
				cuoi = t;
			}
		}
	}
	
	int tong_le() {
		int n=0;
		Node p=head;
		while(p!=null) {
			if(p.data % 2 !=0)
				n= n+p.data;
			p=p.next;
		}
		return n;
	}
	
	double tbc_chan() {
		int k=0, i=0;
		Node p=head;
		while(p!=null) {
			if(p.data %2 ==0) {
				k=k +p.data;
				i++;
			}
			p=p.next;
		}
		return k/i;
	}
	
	int demPt_lonhon3() {
		int i=0;
		Node p=head;
		while(p != null) {
			if(p.data > 3)
				i++;
			p=p.next;
		}
		return i;
	}
	
	//
	int demPT_Khac()
	{
		int i = 0;
		Node p = head;
		while (p != null) {
			boolean isDistinct = false;
			Node temp = p.next;
			while (temp != null) {
				if (p.data == temp.data) {
					isDistinct = true;
					break;
				}
				temp = temp.next;
			}
			if (!isDistinct) {
				i++;
			}
			p = p.next;
		}
		return i;
	}
	
	Node hoanvi_daucuoi(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node p = head;
        while (p.next != null) {
            prev = p;
            p = p.next;
        }

        p.next = head.next;
        prev.next = head;
        head.next = null;

        return p;
    }
	
	void hvi_DauCuoi() {
		Node temp = hoanvi_daucuoi(head);
		System.out.print("\n Noi dung danh sach:\n===>");
		while(temp != null) {
			System.out.println(temp);
			temp=temp.next;
		}
		System.out.print("null \n");
	}
	
	//Dao nguoc danh sach lien ket
	void dao_dslk() {
		Node t = null;
		Node p = head;
		while(p!= null) {
			Node q = p.next;
			p.next = t;
			t =p;
			p=q;
		}
		head = t;
	}
	
	//Hien thi danh sach lien ket
	void in() {
		System.out.print("\n Noi dung danh sach:\n===>");
		Node p= head; 
		while(p != null) {
			System.out.println(p);
			p=p.next;
		}
		System.out.print("null \n");
	}
	
	public static void main(String[] args) throws IOException {
		Main p = new Main();
//		p.nhapds();
		p.doc_file();
		p.in();
		System.out.println("Tong cac so le la: "+p.tong_le());
//		System.out.println("Trung binh cong so chan la: "+p.tbc_chan());
//		System.out.println("So cac so lon hon 3 la: "+p.demPt_lonhon3());
//		System.out.println("So cac so co gia tri khac nhau: "+p.demPT_Khac());
//		System.out.println("Hoan vi dau va cuoi: ");
//		p.hvi_DauCuoi();
//		System.out.println("Dao danh sach line ket: ");
//		p.dao_dslk(); p.in();
	}
}
