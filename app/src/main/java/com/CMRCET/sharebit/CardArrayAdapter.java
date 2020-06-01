package com.CMRCET.sharebit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CardArrayAdapter extends ArrayAdapter<Cards> {
    private static final String TAG="CardArrayAdapter";
    private List<Cards> cardList=new ArrayList<Cards>();
    static class CardViewHolder{
        TextView line1;
        TextView line2;
        TextView line3;
    }
    public CardArrayAdapter(Context context, int textViewResourceId){
        super(context,textViewResourceId);
    }
    @Override
    public void add(Cards object)
    {
        cardList.add(object);
        super.add(object);
    }
    @Override
    public int getCount()
    {
        return this.cardList.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row=convertView;
        CardViewHolder viewHolder;
        if(row==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.list_item_card,parent,false);
            viewHolder=new CardViewHolder();
            viewHolder.line1=(TextView)row.findViewById(R.id.textView);
            viewHolder.line2=(TextView)row.findViewById(R.id.textView2);
            viewHolder.line3=(TextView)row.findViewById(R.id.textView3);
            row.setTag(viewHolder);
        }
        else
        {
            viewHolder=(CardViewHolder)row.getTag();
        }
        Cards card=getItem(position);
        viewHolder.line1.setText(card.getEventTitle());
        viewHolder.line2.setText(card.getEventDetails());
        viewHolder.line3.setText(card.getEventDate().toString());
        return row;
    }
    public Bitmap decodeToBitmap(byte[] decodedByte)
    {
        return BitmapFactory.decodeByteArray(decodedByte,0,decodedByte.length);
    }
}

