package com.bb.salesapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.salesapp.R;
import com.bb.salesapp.model.CustomerModel;

import java.util.ArrayList;
import java.util.List;

public class ListCustomerAdapter extends RecyclerView.Adapter<ListCustomerAdapter.MyViewHolder> {

    public interface MenuEditCategoryListener {
        void onEdit(CustomerModel customerModel );
        void onDelete(CustomerModel customerModel);
    }

    private final List<CustomerModel> customerModels = new ArrayList<>();

    @NonNull
    @Override
    public ListCustomerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_customer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CustomerModel customerModel = customerModels.get(position);
        holder.list_cust_name.setText(customerModel.getCust_name());
        holder.list_cust_contact.setText(customerModel.getCust_contact());
        holder.list_cust_adress.setText(customerModel.getCust_address());
    }

    @Override
    public int getItemCount() {
        return customerModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView list_cust_name, list_cust_contact, list_cust_adress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            list_cust_name = itemView.findViewById(R.id.list_cust_name);
            list_cust_contact = itemView.findViewById(R.id.list_cust_contact);
            list_cust_adress = itemView.findViewById(R.id.list_cust_address);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItems(List<CustomerModel> models) {
        for(CustomerModel customerModel: models) {
            if (customerModels.contains(customerModel)) {
                customerModels.set(customerModels.indexOf(customerModel), customerModel);
            } else {
                customerModels.add(customerModel);
            }
        }

        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateItem(CustomerModel customerModel) {
        customerModels.set(customerModels.indexOf(customerModel), customerModel);
        notifyDataSetChanged();
    }
}
