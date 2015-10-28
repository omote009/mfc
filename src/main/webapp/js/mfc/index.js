$(function() {
    $.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
    $( ".datepicker" ).datepicker();
    $( '.datepicker' ).change( function() {
        $( '.datepicker' ).datepicker( 'option', 'dateFormat', 'yy-mm-dd');
    } );
});

$(function() {
   $( document ).tooltip();
});

/**
 * Enter�L�[�ɂ��t�H�[�J�X�ړ����������邽�߂̊g��function
 * <pre>
 * �g����
 * �擪�̂�����ňȉ��̂悤�ɐ錾����B
 * $(document).EnterTab({Enter:true,Tab:true});
 * </pre>
 */
$.extend($.fn, {
   EnterTab : function(o) {
      /*
       * �t�H�[�J�X�ړ��̑ΏۂɂȂ�input���i���擾�������function�B
       * hidden�A��\���idisplay�Fnone�j�Atabindex="-1"�Ɩ����I�Ɏw��
       * ����Ă�����́Adisabled�Ȃ��̂��Ȃ��Ȃ���A�ォ�珇�Ԃ� input���i���E���Ă����A�ΏۂƂ���I�u�W�F�N�g��Ԃ��B
       *
       */
      var Focus_Move = function(df, i, ln, shift) {
         // �t�H�[�J�X���擾�ł��Ȃ����͔̂�΂��܂�
         var mv;
         if (shift) {
            mv = -1;
         } else {
            mv = 1;
         }
         var j = (i + mv) % ln;
         var Fo, Fs;
         while (i = j) {

            Fo = df[j];
            Fs = Fo.style;
            if (Fo.type != "hidden" && !Fo.disabled && Fo.tabIndex != -1
                  && Fs.visibility != "hidden" && Fs.display != "none") {
               // �Ώۂ̃I�u�W�F�N�g��߂�
               return Fo;
            }
            j = (j + mv) % ln;
         }
         // Hit���Ȃ��ꍇ
         return df[i];
      }

      /*
       * ���ۂ̏����{��
       */
      var d = document;
      var $input = $(":input", this)
      // input�Z���N�^�ŃL�[�_�E���C�x���g���E��
      $input.keydown(function(e) {
         var k = e.keyCode;
         var s = e.shiftKey;
         var obj = e.target;
         // ����t���O false�ł���΃t�H�[�J�X�ړ��̏���������
         var blKey = true;
         /*
          * BackSpace�Ȃ�AIE�̋K��̃C�x���g�𖳌��Ĕ����Ă��܂�
          * IE���������AInput�^�O��ReadOnly�̂Ƃ���BackSpace����������
          * ��ʑJ�ڂ����Ă��܂��āA���ɂ����Ƃ������B
          * �Ȃ̂ŁA�����ŗ}�����Ă����B
          *
          */
         if(k == 8){
            if (d.all)
               window.event.keyCode = 0;
               return true;
         }
         // Enter�ł�Tab�ł��Ȃ���΁Atrue��Ԃ��āA�������I����Ă��܂��B
         if (!o.Enter && k == 13)
            return true;
         if (!o.Tab && k == 9)
            return true;
         // �L�[�R�[�h��Enter(13) �� Tab(9)�̏ꍇ�Ƀt�H�[�J�X�ړ�����B
         if (k == 13 || k == 9) {
            // �^�O���i�őΏۊO�̂��̂ɑ΂��鏈��
            switch (obj.tagName) {
               // Textarea�� Tab�L�[�̂Ƃ��̂ݑΏۂɂ���
               case "TEXTAREA":
                  if (k != 13)
                     blKey = false;
                  break;
               case "INPUT":
               case "SELECT":
                  // input �� select �^�O�͏����ΏہB
                  // �������Atype��file�̎��́A��U�͂���Ǝ��ւʂ���Ȃ��Ȃ��Ă��܂��̂ŁA�ΏۊO�ɂ���B
                  if (obj.type != "file")
                     blKey = false;
                  break;
               default:
            }
            // key�C�x���g������������̂̂ݒ��o
            if (!blKey) {
               // �t�H�[���I�u�W�F�N�g�����Ԗڂ��T��
               var ln = $input.length - 1;
               var i;
               for (i = 0; i < ln; i++) {
                  if ($input[i] == obj)
                     break;
               }
               // ���̃t�H�[���I�u�W�F�N�g�T��
               obj = Focus_Move($input, i, ln, s);
            }
         }

         if (!blKey) {
            /*
             * file �� hidden�̏ꍇ�͏������Ȃ��`�F�b�N���ēx���{�B �O�ł͂����Ă��邪�A�Ȃ��������Ŗ߂��Ă���Ƃ������邽�߁B
             */
            if (obj.type != "file" && obj.type != "hidden") {
               // IE�K��̓���L�����Z��
               if (d.all)
                  window.event.keyCode = 0;
               // �t�H�[�J�X�̈ړ�
               obj.focus();
               // select�^�u�̏ꍇ�͑I��
               if (obj.select && obj.type != "button" && obj.type != "submit") {
                  obj.select();

               //�T�u�~�b�g�{�^���̏ꍇ�A�N���b�N�������s��
               } else if (obj.select && obj.type == "submit") {
                   //obj.click();
               }
            } else {
               blKey = true;
            }
         }
         return blKey;
      });
   }
});

