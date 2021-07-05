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

    $('.user-delete-btn').click(() => {
        if(confirm('本当にユーザーを削除してよろしいですか？')){
            /*　OKの時の処理 */
            $('#user-delete-form').submit();
        }else{
            /* キャンセルの時の処理 */
            return false;
        }
    });
});