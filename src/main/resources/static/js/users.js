$(() => {
    $('#create-btn').click(() => {
        if(confirm('本当にユーザーを登録してよろしいですか？')){
            /*　OKの時の処理 */
            $('#user-create-form').submit();
        }else{
            /* キャンセルの時の処理 */
            return false;
        }
    });
});