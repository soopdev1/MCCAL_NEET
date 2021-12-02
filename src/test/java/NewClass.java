
import com.seta.db.Action;
import com.seta.db.Database;
import com.seta.db.Entity;
import com.seta.domain.Docenti;
import com.seta.domain.DocumentiPrg;
import com.seta.domain.Documenti_Allievi;
import com.seta.domain.ProgettiFormativi;
import com.seta.entity.FadCalendar;
import static com.seta.util.ExportExcel.impostaregistri;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class NewClass {

    public static void main(String[] args) {
//        compileTabella1(56L);
        Database db1 = new Database();
        String base64or = db1.getBase64Report(38);
        List<FadCalendar> calendarioFAD = db1.calendarioFAD("38");
        db1.closeDB();
        Entity e = new Entity();

//        calendarioFAD.forEach(c1 -> {
//        
//            System.out.println(c1.toString());
//        });
        ProgettiFormativi pf = e.getEm().find(ProgettiFormativi.class, 38L);
        List<Docenti> list_docenti = e.getDocentiPrg(pf);
        List<DocumentiPrg> list_doc_pr = e.getDocPrg(pf);
        List<Documenti_Allievi> list_doc_al = e.getDocAllieviPR(pf);
        

//        list_doc_pr.forEach(r1 -> {
//
//            if (r1.getGiorno() != null) {
//                System.out.println("NewClass.main() "+r1.getGiorno().getTime());
//            }
//        });

        impostaregistri(base64or, pf.getAllievi(), calendarioFAD, list_doc_pr, list_doc_al);

//        presenti.add(new Presenti(a.getId(), a.getNome(), a.getCognome(), in, out, getHour(in, out)));
    }
}
