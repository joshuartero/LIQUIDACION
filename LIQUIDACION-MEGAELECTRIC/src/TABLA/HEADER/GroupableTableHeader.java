package TABLA.HEADER;

/**
 *
 * @author JoshuaOrmachea
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class GroupableTableHeader extends JTableHeader {

    @SuppressWarnings("unused")
    private static final String uiClassID = "GroupableTableHeaderUI";

    protected List<ColumnGroup> columnGroups = new ArrayList<ColumnGroup>();

    public GroupableTableHeader(TableColumnModel model) {
        super(model);
        setUI(new GroupableTableHeaderUI());
        setReorderingAllowed(false);
//         setDefaultRenderer(new MultiLineHeaderRenderer());
        Border blackline=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        UIManager.getDefaults().put("TableHeader.cellBorder",blackline);
    }

    @Override
    public void updateUI() {
        setUI(new GroupableTableHeaderUI());
    }

    @Override
    public void setReorderingAllowed(boolean b) {
        super.setReorderingAllowed(false);
    }

    public void addColumnGroup(ColumnGroup g) {
        columnGroups.add(g);
    }

    public List<ColumnGroup> getColumnGroups(TableColumn col) {
        for (ColumnGroup group : columnGroups) {
            List<ColumnGroup> groups = group.getColumnGroups(col);
            if (!groups.isEmpty()) {
                return groups;
            }
        }
        return Collections.emptyList();
    }

    public void setColumnMargin() {
        int columnMargin = getColumnModel().getColumnMargin();
        for (ColumnGroup group : columnGroups) {
            group.setColumnMargin(columnMargin);
        }
    }

}
