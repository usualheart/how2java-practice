package exception;

public class CheckingAccount extends Account {
	double overdraftProtection;
	//���췽�����ÿ�͸֧���
	public CheckingAccount() {
		overdraftProtection=0;
	}
	public CheckingAccount(double x) {
		overdraftProtection=x;
	}
	public double getOverdraftProtection() {
		return overdraftProtection;
	}
	//overide���
	public void deposit(double m) {
		balance+=m;
		System.out.printf("�ֽ��"+m+"Ԫ                       \t�˻���"+getBalance()+"Ԫ"+"\t�˻����ö�ȣ�%.2fԪ%n",overdraftProtection);
	}
	//overideȡ��
	public void withdraw(double m) throws OverdraftException{
		
		if(balance>0&&m<=balance) {
			balance-=m;
			System.out.printf("�˻����ֱ��ȡ����%.2fԪ      \t",m);
			System.out.printf("�˻���"+balance+"Ԫ"+"\t�˻����ö�ȣ�%.2fԪ%n",overdraftProtection);
			}
		else if(m>balance&&m<=balance+overdraftProtection) {
			overdraftProtection-=(m-balance);
			System.out.printf("����͸֧%.2fԪȡ����%.2fԪ\t",m-balance,m);
			balance=0;
			System.out.printf("�˻���"+balance+"Ԫ"+"\t�˻����ö�ȣ�%.2fԪ%n",overdraftProtection);
			}
		else if(m>balance+overdraftProtection) {
			double deficit=m-balance-overdraftProtection;
			System.out.printf("Ƿ��%.2fԪȡ����%.2fԪ\t",m-balance-overdraftProtection,m);
			balance=0;
			overdraftProtection=0;
			throw new OverdraftException("�˻�Ƿ�ѣ�Ƿ�Ѷ",deficit);
			}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Account xiaoming=new CheckingAccount(100);
		try {
			xiaoming.deposit(100);
			xiaoming.withdraw(5.21);
			xiaoming.withdraw(95);
			xiaoming.withdraw(103.5);
		} catch (OverdraftException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.printf("Ƿ�ѣ�%.2fԪ%n",e.getDeficit());
			e.printStackTrace();
		}
	}

}
