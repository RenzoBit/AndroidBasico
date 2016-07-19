package pe.edu.tecsup.androidsesion2;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.tecsup.androidsesion1.R;

/**
 * Created by hrodp on 05/06/2016.
 */
public class AmpliableAdapter extends BaseExpandableListAdapter {

    private final SparseArray<AmpliableGroup> groups;
    public LayoutInflater inflater;
    public Activity activity;

    public AmpliableAdapter(Activity activity, SparseArray<AmpliableGroup> groups) {

        this.activity = activity;
        this.groups = groups;
        this.inflater = activity.getLayoutInflater();

    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ampliable_group, null);
        }
        AmpliableGroup group = (AmpliableGroup) getGroup(groupPosition);
        ((CheckedTextView) convertView).setText(group.titulo);
        ((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView;
        final String children = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ampliable_group, null);
        }
        textView = (TextView) convertView.findViewById(R.id.chkTextView);
        textView.setText(children);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, children, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
