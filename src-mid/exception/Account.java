package exception;

public class Account {
	double balance=0;
	public double getBalance() {
		return balance;
	}
	public void withdraw(double m) throws OverdraftException{
		if(balance>0&&m<balance) {
			balance-=m;
			System.out.printf("成功取出%.2f元\t",m);
			System.out.println("账户余额："+balance+"元");
			}
		else if(balance>0&&m>balance) {
			balance-=m;
			System.out.printf("欠费%.2f元取出：%.2f元\t",-balance,m);
			throw new OverdraftException("账户欠费了，欠费：",balance);
			}
		else if(balance<=0) {
			balance-=m;
			System.out.printf("欠费%.2f元取出：%.2f元\t",m,m);
			throw new OverdraftException("账户欠费了，欠费：",balance);
		}
	}
	public void deposit(double m) {
		balance+=m;
		System.out.println("存了："+m+"元\t余额："+getBalance()+"元。");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Account xiaoming=new Account();
		try {
			xiaoming.deposit(100);
			xiaoming.withdraw(5.21);
			xiaoming.withdraw(95);
			xiaoming.withdraw(3.5);
		} catch (OverdraftException e) {
			// TODO 自动生成的 catch 块
			System.out.printf("欠费账户：%.2f元%n",e.getDeficit());
			e.printStackTrace();
		}

		try {
			
			xiaoming.withdraw(3.5);
		} catch (OverdraftException e) {
			// TODO 自动生成的 catch 块
			System.out.printf("欠费账户：%.2f元%n",e.getDeficit());
			e.printStackTrace();

		}
		try {
			xiaoming.deposit(100);
			xiaoming.withdraw(923.5);
		} catch (OverdraftException e) {
			// TODO 自动生成的 catch 块
			System.out.printf("欠费账户：%.2f元%n",e.getDeficit());
			e.printStackTrace();

		}
	}


}
