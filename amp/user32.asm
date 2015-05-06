.model small
.data
.386
str1 db 10,13,"enter the number: $"
str2 db 10,13,"Result is: $"
a dd ?
b dd ?
y dw 0010
.code
start:
mov ax,@data
mov ds,ax

lea dx,str1 ;to print str1
mov ah,09h
int 21h

mov bx,0000h
mov cl,08h
agn:
	mov ah,01h ;input chracter 
	int 21h

	sub al,30h
	cmp al,0ah
	jc lessThanA
		sub al,07h
	lessThanA:
		shl ebx,1 ;;shift 4 times ie one digit. 1 becomes 10, AA becomes AA0
		shl ebx,1
		shl ebx,1
		shl ebx,1	
		add bl,al
loop agn ; do this 8 times(8 digits)


lea dx,str1
mov ah,09h
int 21h
mov dx,0000h
mov cl,08h
agn2:
	mov ah,01h
	int 21h

	sub al,30h
	cmp al,0ah
	jc lessThanA2
		sub al,07h
	lessThanA2:
		shl edx,1
		shl edx,1
		shl edx,1
		shl edx,1	
		add dl,al
loop agn2
add ebx,edx

lea dx,str2 ;print string 2
mov ah,09h
int 21h

mov al,00h	;to print carry
adc al,00h
add al,30h
mov dl,al
mov ah,02h
int 21h

mov cx,8
agn1:	
	rol ebx,4		;;left most digit to be printed first, so rotate
	mov al,bl
	and al,0fh
	cmp al,0ah
	jc agn20 
	add al,07h

agn20:	
	add al,30h
	mov dl,al		;;print the char
	mov ah,02h
	int 21h
loop agn1		;; do this for all 8 chars



mov ah,4ch
int 21h
end start
