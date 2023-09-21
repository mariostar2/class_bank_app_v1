<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>


<div class="col-sm-8">
    <h2>이체페이지(인증)</h2>
    <h5>어서오세요 환영합니다</h5>
    <div class="bg-light p-md-5 h-75">
        <div class="form-group">
            <form action="/account/transfer" method="post">
                <div>
                    <label for="amount">이체 금액: </label>
                    <input type="text" id="amount" class="form-control" placeholder="이체금액입력" name="amount">
                </div>
                <br>
                <div>
                    <label for="wAccountNumber">출금 계좌번호: </label>
                    <input type="text" id="wAccountNumber" class="form-control" placeholder="출금 계좌 입력" name="wAccountNumber">
                </div>
                <div>
                    <label for="dAccountNumber">이체 계좌번호: </label>
                    <input type="text" id="dAccountNumber" class="form-control" placeholder="이체 계좌번호" name="dAccountNumber">
                </div>
                <br>
                <div>
                    <label for="wAccountPassword">출금계좌비밀번호: </label>
                    <input type="text" id="wAccountPassword" class="form-control" placeholder="출금계좌비밀번호" name="wAccountPassword">
                </div>
                <br>

                <button type="submit" class="btn btn-primary">이체하기</button>
            </form>
        </div>
    </div>
  </div>
</div>
</div>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>