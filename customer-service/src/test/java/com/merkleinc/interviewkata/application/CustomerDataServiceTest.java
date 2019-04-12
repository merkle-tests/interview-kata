package com.merkleinc.interviewkata.application;

import com.merkleinc.interviewkata.repository.CustomerRepository;
import com.merkleinc.interviewkata.repository.exception.RepositoryException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.merkleinc.interviewkata.application.CustomerBuilder.aCustomer;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDataServiceTest {

    private static final String CUSTOMER_ID = "testCustomerId";
    private static final String ONE_WORD_NAME = "ONE";
    private static final String TWO_WORD_NAME = "ONE TWO";
    private static final String ONE = "ONE";
    private static final String TWO = "TWO";
    private static final String THREE_WORD_NAME = "ONE TWO THREE";
    private static final String THREE = "THREE";
    private static final String FOUR_WORD_NAME = "ONE TWO THREE FOUR";
    private static final String FOUR = "FOUR";
    private static final String TWO_THREE = "TWO THREE";
    private CustomerDataService testSubject;

    @Mock
    private CustomerRepository customerRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void init() {
        testSubject = new CustomerDataService(customerRepository);
    }

    @Test
    public void exceptionPropagated_whenCustomerNotFound() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenThrow(new RepositoryException(""));

        //When
        try {
            testSubject.getCustomer(CUSTOMER_ID);
        } finally {
            //Then
            expectedException.expect(RepositoryException.class);
        }
    }

    @Test
    public void noCustomerFirstName_middleName_or_lastName_whenRepoProvidesNoName() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), nullValue());
        assertThat(actualValue.getMiddleName(), nullValue());
        assertThat(actualValue.getLastName(), nullValue());

    }

    @Test
    public void noCustomerFirstName_middleName_or_lastName_whenRepoProvidesEmptyName() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).withName("").build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), nullValue());
        assertThat(actualValue.getMiddleName(), nullValue());
        assertThat(actualValue.getLastName(), nullValue());
    }

    @Test
    public void noCustomerFirstName_middleName_or_lastName_whenRepoProvidesBlankName() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).withName("   ").build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), nullValue());
        assertThat(actualValue.getMiddleName(), nullValue());
        assertThat(actualValue.getLastName(), nullValue());
    }

    @Test
    public void customerFirstName_whenRepoProvidesNameWithSingleWord() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).withName(ONE_WORD_NAME).build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), equalTo(ONE));
        assertThat(actualValue.getMiddleName(), nullValue());
        assertThat(actualValue.getLastName(), nullValue());
    }

    @Test
    public void customerFirstName_and_customerLastName_whenRepoProvidesNameWithTwoWords() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).withName(TWO_WORD_NAME).build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), equalTo(ONE));
        assertThat(actualValue.getMiddleName(), nullValue());
        assertThat(actualValue.getLastName(), equalTo(TWO));
    }

    @Test
    public void customerFirstName_customerMiddleName_andCustomerLastName_whenRepoProvidesNameWithThreeWords() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).withName(THREE_WORD_NAME).build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), equalTo(ONE));
        assertThat(actualValue.getMiddleName(), equalTo(TWO));
        assertThat(actualValue.getLastName(), equalTo(THREE));
    }

    @Test
    public void customerFirstName_customerMiddleName_andCustomerLastName_whenRepoProvidesNameWithFourWords() throws RepositoryException {

        //Given
        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(aCustomer(CUSTOMER_ID).withName(FOUR_WORD_NAME).build());

        //When
        Customer actualValue = testSubject.getCustomer(CUSTOMER_ID);

        //Then
        assertThat(actualValue, notNullValue());
        assertThat(actualValue.getFirstName(), equalTo(ONE));
        assertThat(actualValue.getMiddleName(), equalTo(TWO_THREE));
        assertThat(actualValue.getLastName(), equalTo(FOUR));
    }

}