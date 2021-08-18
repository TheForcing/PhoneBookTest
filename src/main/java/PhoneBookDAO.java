import java.util.List;



public interface PhoneBookDAO {
	public List<PhonebookVO> getlist();
	public String insert(PhonebookVO vo);
	public String delete(PhonebookVO vo);
	public String search(PhonebookVO vo);
	public String exit(PhonebookVO vo);

}
