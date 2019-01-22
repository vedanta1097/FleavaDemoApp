package com.example.vedanta.fleavatest.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vedanta.fleavatest.R;
import com.example.vedanta.fleavatest.model.Spirit;

import java.util.List;

import static com.example.vedanta.fleavatest.util.Constant.SPIRIT_IMAGE_URL;
import static com.example.vedanta.fleavatest.util.Constant.SPIRIT_URL;

public class SpiritAdapter extends RecyclerView.Adapter<SpiritAdapter.SpiritViewHolder> {
    private List<Spirit> mSpirits;
    private Context mContext;

    public SpiritAdapter(List<Spirit> spirits, Context context) {
        this.mSpirits = spirits;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SpiritViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spirit_item_row, viewGroup, false);
        return new SpiritViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpiritViewHolder holder, int position) {
        if (mSpirits != null) {
            String category = mSpirits.get(position).getCategory();
            String title = mSpirits.get(position).getTitle();
            category = category.length() > 10 ? category.substring(0,10) + "..." : category;
            title = title.length() > 50 ? title.substring(0,50) + "..." : title;

            holder.tvCategory.setText(category);
            holder.tvTitle.setText(title);

            String image = SPIRIT_IMAGE_URL + mSpirits.get(position).getImage();
            Glide.with(mContext).load(image).into(holder.imageViewSpirit);
        }
    }

    @Override
    public int getItemCount() {
        if (mSpirits != null) {
            return mSpirits.size();
        } else {
            return 0;
        }
    }

    public class SpiritViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCategory, tvTitle;
        private final ImageView imageViewSpirit;

        public SpiritViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.spirit_category);
            tvTitle = itemView.findViewById(R.id.spirit_title);
            imageViewSpirit = itemView.findViewById(R.id.spirit_imageview);
        }
    }
}
