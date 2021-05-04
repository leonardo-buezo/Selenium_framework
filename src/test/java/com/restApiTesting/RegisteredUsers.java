package com.restApiTesting;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "firstName",
        "userId",
        "userUuid",
        "loanApplications",
        "loansInReview"
})
public class RegisteredUsers {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("userUuid")
    private String userUuid;
    @JsonProperty("loanApplications")
    private List<Object> loanApplications = null;
    @JsonProperty("loansInReview")
    private List<LoansInReview> loansInReview = null;

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("userUuid")
    public String getUserUuid() {
        return userUuid;
    }

    @JsonProperty("userUuid")
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @JsonProperty("loanApplications")
    public List<Object> getLoanApplications() {
        return loanApplications;
    }

    @JsonProperty("loanApplications")
    public void setLoanApplications(List<Object> loanApplications) {
        this.loanApplications = loanApplications;
    }

    @JsonProperty("loansInReview")
    public List<LoansInReview> getLoansInReview() {
        return loansInReview;
    }

    @JsonProperty("loansInReview")
    public void setLoansInReview(List<LoansInReview> loansInReview) {
        this.loansInReview = loansInReview;
    }
}
