package PhonebookPJ;
import java.util.List;



public interface PhoneBookDAO {
	public List<PhoneBookVo> getlist();
	public String insert(PhoneBookVo vo);
	public String delete(PhoneBookVo vo);
	public String search(PhoneBookVo vo);
	public String exit(PhoneBookVo vo);

}
