package PhonebookPJ;
import java.util.List;



public interface PhoneBookDAO {
	public List<PhoneBookVo> getlist();
	public boolean insert(PhoneBookVo vo);
	public boolean delete(PhoneBookVo vo);
	public List<PhoneBookVo> search(PhoneBookVo vo);
	

}
