package stream;

import org.junit.*;
import java.util.*;
import stream.Member;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class MemberStreamTest {
	
	private List<Member> members = new ArrayList<Member>();
	
	@Before
	public void setUp() {
		Member member1 = new Member("Aaron", "SDK20160814", 40, false);
		Member member2 = new Member("Lina", "SDK20150407", 34, false);
		Member member3 = new Member("Ronan", "SDK20151226", 52, true);
		Member member4 = new Member("Brad", "SDK20140610", 28, false);
		Member member5 = new Member("Angel", "SDK20120209", 44, true);		
		
		members = Arrays.asList(member1, member2, member3, member4, member5);
	}
	
	
	@Test
	public void testSortRegisteredMembers() {
		List<Member> memberList = members.stream().filter(m->m.getIdentification().startsWith("SDK2015"))
			            .sorted((m1,m2)->m1.getIdentification().compareTo(m2.getIdentification()))
						.collect(Collectors.toList());
		
		assertThat(memberList, hasSize(2));
		assertThat(memberList.stream().map(m->m.getName()).collect(Collectors.toList()), contains("Lina", "Ronan"));		
	}
	
	@Test 
	public void testAverageMemberAge() {
		OptionalDouble averageAge = members.stream().mapToDouble(m->m.getAge()).average();	
		
		double expectedAverage = (40+34+52+28+44)/(double)5;
		
		assertThat(averageAge.getAsDouble(), equalTo(expectedAverage));
	}

}