package PhonebookPJ;
import java.util.List;



public interface PhoneBookDAO {
	public List<PhoneBookVo> getlist();
	public int insert(PhoneBookVo vo);
	public int delete(Long pk);
	public List<PhoneBookVo> search(PhoneBookVo vo);
	

}
