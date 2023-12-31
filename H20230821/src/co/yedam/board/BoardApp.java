package co.yedam.board;
import java.util.List;
import java.util.Scanner;

public class BoardApp {

	Scanner scn = new Scanner(System.in);
//	BoardService service = new BoardServiceImpl();
	BoardService service = new BoardServiceJdbc();
//	UserService uservice = new UserServiceImpl();
	UserService uservice = new UserServiceJdbc();
	ReplyService rservice = new ReplyServiceJdbc();
//	ReplyService rservice = new ReplyServiceImpl();
	
	User loginList = null;
	String name;
	String userId;

	public void start() {
		boolean run = true;		
				
		while(true) {
			String id = printString("아이디입력");
			String pw = printString("패스워드입력");
			
			loginList = new User(id, pw);			

			if(uservice.checkLogin(loginList)) {
				name = uservice.hellow(loginList);
				userId = id;
				System.out.printf("%s님 환영합니다.\n",name);
				break;
			}else {
				System.out.println("로그인 실패..");
			}
		}
		

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
		String writer = userId;
		Board board = new Board(title, content, writer);

		if (service.add(board)) {
			System.out.println("등록완료!!");
		}else {
			System.out.println("등록실패!!");
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
			} else {
				System.out.println("숫자를 입력해주세요.");
				pageNo = Integer.toString(lastPage);
			}
		}
	}
	
	

	void modify() {
		String brdNo = printString("번호입력");
		String nullCheck = service.getResponseUser(Integer.parseInt(brdNo));
		
		if(nullCheck != null) {
			if(!service.getResponseUser(Integer.parseInt(brdNo)).equals(userId)) {
				System.out.println("권한이 없습니다.");
				return;
			}
		}else {
			System.out.println("해당글번호가 없습니다.");
			return;
		}
		
		
		String content = printString("내용입력");
		Board brd = new Board();

		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if (service.modify(brd)) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
	}

	void remove() {
		String brdNo = printString("삭제할 번호 입력");
		String nullCheck = service.getResponseUser(Integer.parseInt(brdNo));

		if (nullCheck != null) {
			if (!service.getResponseUser(Integer.parseInt(brdNo)).equals(userId)) {
				System.out.println("권한이 없습니다.");
				return;
			}
		} else {
			System.out.println("해당글번호가 없습니다.");
			return;
		}
		
		if (service.remove(Integer.parseInt(brdNo))) {
			System.out.println("삭제완료");
		}
	}

	void search() {	
		Board result = null;
		String brdNo = printString("번호 입력");
		try {

			result = service.search(Integer.parseInt(brdNo));
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요.");
			return;
		}

		if (result == null) {
			System.out.println("해당글번호가 없습니다.");
		} else {
			System.out.println(result.showInfo());

			ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
			rapp.start();
		}
	}
	
	class ReplyApp {
		//필드
		private ReplyService rservice = new ReplyServiceJdbc();
		private int brdNo;
		
		public ReplyApp(int brdNo) {
			this.brdNo = brdNo;
		}
		
		public ReplyApp(ReplyService rservice, int brdNo) {
			super();
			this.rservice = rservice;
			this.brdNo = brdNo;
		}

		public void start() {
			
			boolean run = true;
			int menu;
			
			while(run) {
				System.out.println();
				System.out.println("1.댓글달기 2.댓글목록 3.댓글삭제 4.종료");
				System.out.print("선택>> ");
				menu = scn.nextInt();
				scn.nextLine();					
				
				switch (menu) {
				case 1:
					commRegister();
					break;
				case 2:
					commList();
					break;
				case 3:
					commRemove();
					break;		
				case 4:
					run = false;
					break;	
				default:
					System.out.println("메뉴에 없는 번호입니다.");
					break;
				}
			}
			
		
		}
		
		//댓글 생성
		void commRegister() {		
//			String brdNo = printString("번호입력");
			
			if(!rservice.listCheck((brdNo))){
				System.out.println("해당글번호가 없습니다.");
				return;
			}			
			String content = printString("댓글내용입력");
			String writer = userId;
			Reply comm = new Reply(brdNo, content, writer);

			if (rservice.add(comm)) {
				System.out.println("등록완료!!");
			}else {
				System.out.println("등록실패!!");
			}
		}
		
		//댓글 목록
		void commList() {
			String pageNo = "1";
			while (true) {

				List<Reply> list = rservice.list(Integer.parseInt(pageNo), brdNo);

				for (Reply b : list) {
					System.out.println(b.listInfo());
				}

				int totalCnt = rservice.getTotal(brdNo);
				if(totalCnt != 0) {
					int lastPage = (int) Math.ceil(totalCnt / 5.0);
					System.out.print("Page:");	
					for (int i = 1; i <= lastPage; i++) {				
						if(i == Integer.parseInt(pageNo)) {
							System.out.printf("  (%d)", i);
						}else {
							System.out.printf("  %d", i);
						}
					}
					System.out.println();
				}				

				pageNo = printString("페이지입력(exit=q)");

				if (pageNo.equals("q")) {
					System.out.println("페이지 탐색을 종료합니다.");
					break;
				}else {
					continue;
				}
			}
		}
		
		//댓글삭제
		void commRemove() {
			String delNo = printString("삭제할 번호 입력");
			String nullCheck = rservice.getResponseUser(brdNo);

			if (nullCheck != null) {
				if (!rservice.getResponseUser(brdNo).equals(userId)) {
					System.out.println("권한이 없습니다.");
					return;
				} else {
					if (rservice.remove(Integer.parseInt(delNo))) {
						System.out.println("삭제완료");
					} else {
						System.out.println("해당글번호가 없습니다.");
						return;
					}
				}
			}
		}
		
		private String printString(String msg) {
			System.out.print(msg + " >>");
			return scn.nextLine();
		}
	}
}
