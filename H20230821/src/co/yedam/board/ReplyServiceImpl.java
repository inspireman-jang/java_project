package co.yedam.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReplyServiceImpl implements ReplyService {
	
	List<User> userList = new ArrayList<>();

	File file = new File("c:/temp/user.txt");

	@Override
	public boolean add(Reply comm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reply> list(int page, int brdNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal(int brdNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int brdNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean listCheck(int brdNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getResponseUser(int brdNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
