package com.davidcryer.accountalert.addaccount;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.davidc.uiwrapper.UiWrapper;
import com.davidc.uiwrapper.UiWrapperFactoryFragment;
import com.davidcryer.accountalert.R;
import com.davidcryer.accountalert.common.Dates;
import com.davidcryer.accountalert.common.Strings;
import com.davidcryer.accountalert.common.domain.AccountSubmission;
import com.davidcryer.accountalert.common.domain.RepeatType;
import com.davidcryer.accountalert.common.framework.uiwrapper.UiWrapperFactory;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddAccountFragment extends UiWrapperFactoryFragment<AddAccountUi, AddAccountUi.Listener, UiWrapperFactory> {
    private Unbinder unbinder;
    private DatePickerDialog datePickerDialog;
    private Date selectedReminder;
    private String selectedRepeatType;
    @BindView(R.id.title_layout)
    TextInputLayout titleInputLayout;
    @BindView(R.id.title_edit)
    EditText titleEdit;
    @BindView(R.id.description_layout)
    TextInputLayout descriptionInputLayout;
    @BindView(R.id.description_edit)
    EditText descriptionEdit;
    @BindView(R.id.repeat_type)
    Spinner repeatTypeSpinner;
    @BindView(R.id.reminder)
    TextView reminderText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_account, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedState) {
        super.onViewCreated(view, savedState);
        setUpRepeatTypeSpinner(view.getContext());
    }

    private void setUpRepeatTypeSpinner(final Context context) {
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.repeat_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        repeatTypeSpinner.setAdapter(adapter);
        repeatTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRepeatType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (datePickerDialog != null) {
            datePickerDialog.dismiss();
            datePickerDialog = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //noinspection ConstantConditions
        getActivity().setTitle(R.string.screen_title_add_account);
    }

    @OnClick(R.id.reminder)
    void openReminderDialog() {
        final Context context = getContext();
        if (context != null) {
            final Calendar c = Calendar.getInstance();
            datePickerDialog = new DatePickerDialog(context, (datePicker, year, month, dayOfMonth) -> {
                onSelect(new GregorianCalendar(year, month, dayOfMonth).getTime());
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.getDatePicker().setMinDate(Dates.midnightTomorrow().getTime());
            datePickerDialog.setOnDismissListener(dialog -> datePickerDialog = null);
            datePickerDialog.show();
        }
    }

    private void onSelect(final Date date) {
        selectedReminder = date;
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        reminderText.setText(dateFormat.format(selectedReminder));
    }

    @OnClick(R.id.submit)
    void submit() {
        listener().onSubmitNewAccount(ui(), submission());
    }

    private AccountSubmission submission() {
        return new AccountSubmission(titleEdit.getText().toString(), descriptionEdit.getText().toString(), selectedReminder, RepeatType.from(selectedRepeatType));
    }

    @Override
    protected AddAccountUi ui() {
        return new AddAccountUi() {
            @Override
            public void titleError(String error) {
                if (getView() != null) {
                    titleInputLayout.setError(error);
                }
            }

            @Override
            public void reminderError(String error) {
                genericError(error);
            }

            @Override
            public void genericError(String error) {
                if (Strings.isNullOrEmpty(error)) {
                    return;
                }
                final View root = getView();
                if (root != null) {
                    Snackbar.make(root, error, Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void dismiss() {
                final Activity activity = getActivity();
                if (activity != null) {
                    getActivity().onBackPressed();//TODO check if correct
                }
            }
        };
    }

    @Override
    protected UiWrapper<AddAccountUi, AddAccountUi.Listener, ?> uiWrapper(UiWrapperFactory uiWrapperFactory, @Nullable Bundle savedState) {
        return uiWrapperFactory.addAccount(savedState);
    }
}
