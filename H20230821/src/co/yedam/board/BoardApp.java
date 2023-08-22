package co.yedam.board;
import java.util.List;
import java.util.Scanner;

public class BoardApp {

	Scanner scn = new Scanner(System.in);
//	BoardService service = new BoardServiceImpl();
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceImpl();
	User loginList = null;
	String name;
	String userId;

	public void start() {
		boolean run = true;		
				
//		while(true) {
//			String id = printString("아이디입력");
//			String pw = printString("패스워드입력");
//			
//			loginList = new User(id, pw);			
//
//			if(uservice.checkLogin(loginList)) {
//				name = uservice.hellow(loginList);
//				userId = id;
//				System.out.printf("%s님 환영합니다.\n",name);
//				break;
//			}else {
//				System.out.println("로그인 실패..");
//			}
//		}
		

		while (run) {
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine();

			switch (menu) {
			case 1: // 등록
				register();
				break;
			case 2: // 목록
				boardList();
				break;
			case 3: // 수정
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				search();
				break;
			case 9:
				System.out.println("종료합니다.");
				service.save();
				run = false;
				break;
			default:
				System.out.println("메뉴를 확인 해주세요.");
			}
		}
		System.out.println("end of prog.");
	}// end of start.

	private String printString(String msg) {
		System.out.print(msg + " >>");
		return scn.nextLine();
	}

	void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
//		String writer = printString("작성자입력");
		String writer = name;
		Board board = new Board(title, content, writer);

		if (service.add(board)) {
			System.out.println("등록완료!!");
		}
	}

	void boardList() {
		String pageNo = "1";
		while (true) {

			List<Board> list = service.list(Integer.parseInt(pageNo));

			for (Board b : list) {
				System.out.println(b.listInfo());
			}

			int totalCnt = service.getTotal();
			int lastPage = (int) Math.ceil(totalCnt / 5.0);
			System.out.print("Page:");	
//			System.out.println(totalCnt);
			for (int i = 1; i <= lastPage; i++) {				
				if(i == Integer.parseInt(pageNo)) {
					System.out.printf("  (%d)", i);
				}else {
					System.out.printf("  %d", i);
				}
			}
			System.out.println();

			pageNo = printString("페이지입력(exit=q)");

			if (pageNo.equals("q")) {
				System.out.println("페이지 탐색을 종료합니다.");
				break;
			}
		}
	}

	void modify() {
		String brdNo = printString("번호입력");
		String content = printString("내용입력");
		Board brd = new Board();

		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if (service.modify(brd)) {
			System.out.println("수정완료");
		}
	}

	void remove() {
		String brdNo = printString("삭제할 번호 입력");
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제완료");
		}
	}

	void search() {
		String brdNo = printString("번호 입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if (result == null) {
			System.out.println("해당글번호가 없습니다.");
		}else {			
			System.out.println(result.showInfo());
		}
	}
}
