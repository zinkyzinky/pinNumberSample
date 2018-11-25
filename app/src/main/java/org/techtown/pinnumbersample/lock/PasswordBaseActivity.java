package org.techtown.pinnumbersample.lock;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.techtown.pinnumbersample.R;
import org.techtown.pinnumbersample.databinding.ActivityPasswordManagerBinding;

import java.util.Objects;

import static org.techtown.pinnumbersample.BaseViewModel.RESULT_CODE_CANCELED;
import static org.techtown.pinnumbersample.BaseViewModel.RESULT_CODE_ERROR;
import static org.techtown.pinnumbersample.BaseViewModel.RESULT_CODE_SUCCESS;
import static org.techtown.pinnumbersample.lock.PasswordBaseViewModel.JOB_CODE_INIT_FINGER_AUTH;
import static org.techtown.pinnumbersample.lock.PasswordBaseViewModel.JOB_CODE_PIN_AUTH;

public class PasswordBaseActivity extends AppCompatActivity {


    private PasswordBaseViewModel passwordBaseViewModel;

    private KeypadManager mKeypadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initActivity();
//        setContentView(R.layout.activity_password_base);
    }



    protected void initActivity(){

        ActivityPasswordManagerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_password_manager);
        binding.setVm(passwordBaseViewModel);
        binding.setLifecycleOwner(this);

        mKeypadManager = new KeypadManager(this);
        passwordBaseViewModel.getInitNumberKeypad().observe(this, this::initNumberKeypad);
        passwordBaseViewModel.getResult().observe(this, jobResult -> {

            if (jobResult.is(JOB_CODE_PIN_AUTH, RESULT_CODE_ERROR)) {
                Throwable t = jobResult.getThrowable();
                if (t != null) {
//                    showErrorPopup(t).observe(this, throwable -> {
//                        if (Objects.equals(t, throwable)) {
//                            onError();
//                        }
//                    });
                }
            }
            if (jobResult.is(JOB_CODE_PIN_AUTH, RESULT_CODE_CANCELED)) {
                onCanceled();
            }
            if (jobResult.is(JOB_CODE_PIN_AUTH, RESULT_CODE_SUCCESS)) {
                onCompleted();
            }
        });

        passwordBaseViewModel.init();
    }



    /**
     * 키패드 초기화.
     *
     * @param v
     */
    private void initNumberKeypad(Void v) {
        mKeypadManager.initNumberKeypad();
    }

    /**
     * 작업 취소.
     */
    protected void onCanceled() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    /**
     * 작업 완료시.
     */
    protected void onCompleted() {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
