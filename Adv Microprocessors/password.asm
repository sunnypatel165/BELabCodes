.model small
.data
.386
str1 db 10,13,"Enter the password: $"
str2 db 10,13,"Correct Password! Do you want to chnage the password? $"
str3 db 10,13,"Sorry, incorrect password $"
str4 db 10,13,"Enter new password:$"
str5 db 10,13,"password changed!$"
pw db "hello$"
ip db 100 dup("$")
len db 0
olen db 05h

.code
start:
mov ax,@data
mov ds,ax
agn:

lea dx,str1
mov ah,09h
int 21h

lea si,ip

mov cl,00h
ipmore:
mov bl,0dh	;;0d space
mov dl,2ah	;;2a star
mov ah,07	;;char without echo
int 21h
cmp bl,al
jz done
	mov [si],al
	inc si
	mov ah,02
	int 21h
	inc cl
	jmp ipmore

done:

cmp olen,cl
jz lencorrect
bye:
	lea dx,str3
	mov ah,09h
	int 21h
	jmp alldone

lencorrect:
	mov cl,olen

check:
	lea si,ip
	lea di,pw
	mov al,[si]
	mov bl,[di]
	cmp al,bl
	jnz bye
loop check

lea dx,str2
mov ah,09
int 21h

mov ah,01h
int 21h
cmp al,6eh
jz alldone

lea dx,str4
mov ah,09h
int 21h


lea si,pw
mov cl,00h
ipmore1:
mov bl,0dh
mov dl,2ah
mov ah,07h
int 21h
cmp bl,al
jz done1
	mov [si],al
	inc si
	mov ah,02
	int 21h
	inc cl
	jmp ipmore1
done1:
mov olen,cl

lea dx,str5
mov ah,09h
int 21h
jmp agn

alldone:
mov ah,4ch
int 21h
end start