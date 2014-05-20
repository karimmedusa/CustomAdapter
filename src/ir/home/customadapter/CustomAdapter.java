package ir.home.customadapter;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {

    private Activity              activity;
    private List<Student>         data;
    private static LayoutInflater inflater    = null;

    Student                       tempStudent = null;
    int                           i           = 0;


    public CustomAdapter(Activity a, List<Student> students) {

        activity = a;
        data = students;

        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {

        if (data.size() <= 0)
            return 1;
        return data.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;

        if (convertView == null)
            vi = inflater.inflate(R.layout.list_item, null);

        TextView text = (TextView) vi.findViewById(R.id.text);
        TextView text1 = (TextView) vi.findViewById(R.id.text1);
        TextView text2 = (TextView) vi.findViewById(R.id.text2);

        if (data.size() <= 0)
        {
            text.setText("No Data");
        }
        else
        {
            tempStudent = (Student) data.get(position);

            text.setText(tempStudent.getUserName());
            text1.setText(tempStudent.getComment());
            text2.setText(tempStudent.getId());

        }
        return vi;
    }
}
