package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class User{
	String name;
	String pw;
	
	public User(String name, String pw) {
		super();
		this.name = name;
		this.pw = pw;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		User target = (User) obj;
		
		return this.name.equals(target.name) 
				&& this.pw.equals(target.pw);
	}
	
	
}

public class MapExe {
	public static void main(String[] args) {
		// Map = 키 & 값이 설정 되어야 함
		Map<String, Integer> map = new HashMap<>();
		
		map.put("홍길동", 85);
		map.put("김길동", 80);
		map.put("동길동", 75);		
		
		
		Integer val = map.get("김길동");
		System.out.println(val);
		
		List<User> users = new ArrayList<>();
		users.add(new User("user1", "1234"));
		
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("user2", "1111");
		userMap.put("user3", "2222");
		userMap.put("user4", "3333");
		
		
		if (userMap.containsKey("user2")) {
			System.out.println(userMap.get("user2"));
		}
		
		// key 값을 반환 받은 후 호출 해서 전체 출력
		
		Set<String> keyset =  userMap.keySet();
		for(String key : keyset) {
			String value = userMap.get(key);
			System.out.printf("key: %s, value: %s\n", key, value);
		}
		
		//map
		
		Map<User, String> umap = new HashMap<User, String>();
		umap.put(new User("user1", "1111"), "홍길동");
		umap.put(new User("user2", "2222"), "김길동");
		umap.put(new User("user3", "3333"), "동길동");
		
		String name = umap.get(new User("user2", "2222"));
		System.out.println("name: " + name);
		
	}
	
	
}
