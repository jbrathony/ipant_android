package com.ipant.activities.bank_Id_integration;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.ipant.RequestResultInterface;
import com.ipant.network_communication.NetworkConn;

public class BankIdViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private NetworkConn.onRequestResponse onRequestResponse;
    private RequestResultInterface requestResultInterface;
    private Application application;

    /**
     * Creates a {@code AndroidViewModelFactory}
     *
     * @param application an application to pass in {@link AndroidViewModel}
     */
    public BankIdViewModelFactory(@NonNull Application application, RequestResultInterface requestResultInterface, NetworkConn.onRequestResponse onRequestResponse) {
        super(application);
        this.application = application;
        this.onRequestResponse = onRequestResponse;
        this.requestResultInterface = requestResultInterface;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BankIdViewModel(application, requestResultInterface, onRequestResponse);
    }

}
