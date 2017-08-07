package digvijaysingh.customapize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yayandroid.parallaxrecyclerview.ParallaxViewHolder;

public class MapTypeAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private int[] imgRes = {
            R.drawable.starynight,
            R.drawable.retro,
            R.drawable.darknight,
            R.drawable.ironman,
            R.drawable.bnw,
            R.drawable.denim};
    private String[] mapStyle = {
            "Starry Night",
            "Ancient westeros",
            "Dark knight's favourite",
            "Tony stark's World",
            "Colorless beauty",
            "Old muddy denim"};

    private String[] textColor = {
            "#0F2439",
            "#4B7536",
            "#000000",
            "#841100",
            "#414141",
            "#B58A00"};

    private String[] bgColor = {
            "#FFDF34",
            "#FFCC61",
            "#A5A4A5",
            "#FFC042",
            "#DDDBDE",
            "#2A576C"};


    public MapTypeAdapter(Context mContext) {
        this.mContext = mContext;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.row_item_map_type, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).tvMap.setText(mapStyle[position]);
        ((ViewHolder) holder).tvMap.setTextColor(Color.parseColor(textColor[position]));
        ((ViewHolder) holder).tvMap.setBackgroundColor(Color.parseColor(bgColor[position]));
        ((ViewHolder) holder).getBackgroundImage().setImageResource(imgRes[position]);
        ((ViewHolder) holder).getBackgroundImage().reuse();
    }

    @Override
    public int getItemCount() {
        return mapStyle.length;
    }

    class ViewHolder extends ParallaxViewHolder {

        TextView tvMap;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMap = (TextView) itemView.findViewById(R.id.tvMap);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MapActivity.class);
                    intent.putExtra("position", getAdapterPosition());
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) mContext, (View) tvMap, "title");
                    mContext.startActivity(intent, options.toBundle());
                }
            });

        }

        @Override
        public int getParallaxImageId() {
            return R.id.imageView;
        }
    }


}