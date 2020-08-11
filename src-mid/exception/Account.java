package exception;

public class Account {
	double balance=0;
	public double getBalance() {
		return balance;
	}
	public void withdraw(double m) throws OverdraftException{
		if(balance>0&&m<balance) {
			balance-=m;
			System.out.printf("�ɹ�ȡ��%.2fԪ\t",m);
			System.out.println("�˻���"+balance+"Ԫ");
			}
		else if(balance>0&&m>balance) {
			balance-=m;
			System.out.printf("Ƿ��%.2fԪȡ����%.2fԪ\t",-balance,m);
			throw new OverdraftException("�˻�Ƿ���ˣ�Ƿ�ѣ�",balance);
			}
		else if(balance<=0) {
			balance-=m;
			System.out.printf("Ƿ��%.2fԪȡ����%.2fԪ\t",m,m);
			throw new OverdraftException("�˻�Ƿ���ˣ�Ƿ�ѣ�",balance);
		}
	}
	public void deposit(double m) {
		balance+=m;
		System.out.println("���ˣ�"+m+"Ԫ\t��"+getBalance()+"Ԫ��");
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Account xiaoming=new Account();
		try {
			xiaoming.deposit(100);
			xiaoming.withdraw(5.21);
			xiaoming.withdraw(95);
			xiaoming.withdraw(3.5);
		} catch (OverdraftException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.printf("Ƿ���˻���%.2fԪ%n",e.getDeficit());
			e.printStackTrace();
		}

		try {
			
			xiaoming.withdraw(3.5);
		} catch (OverdraftException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.printf("Ƿ���˻���%.2fԪ%n",e.getDeficit());
			e.printStackTrace();

		}
		try {
			xiaoming.deposit(100);
			xiaoming.withdraw(923.5);
		} catch (OverdraftException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.printf("Ƿ���˻���%.2fԪ%n",e.getDeficit());
			e.printStackTrace();

		}
	}


}
