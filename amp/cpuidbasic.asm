.model small
.586
.data
Str1 db 10,13,"$"
str2 db 10,13,"The maximum value of Ax is:$ "
str3 db 10,13,"Stepping ID is: $"
str4 db 10,13,"Model is: $"
str5 db 10,13,"Family is: $"
str6 db 10,13,"Processor type is: $"
str7 db 10,13,"Supports debug extensions$"
str8 db 10,13,"Does not support debug extensions$"
str9 db 10,13,"On-chip FPU$"
str10 db 10,13,"No on-chip FPU$"

eax1 dd ?
ebx1 dd ?
ecx1 dd ?
edx1 dd ?
count db 02h
c db 0
.code
start:
mov ax,@data
mov ds,ax
mov ax,0000h
cpuid

mov eax1,eax
mov ebx1,ebx
mov ecx1,ecx
mov edx1,edx

lea dx,str2   ;to print the max of ax
mov ah,09h
int 21h
mov eax,eax1
add al,37h
mov dl,al
mov ah,02h
int 21h
lea dx,str1  ;new line
mov ah,09h
int 21h


mov ebx,ebx1 ; to print geniuneintel

genu:
	mov dl,bl
	mov ah,02h
	int 21h

	mov dl,bh
	mov ah,02h
	int 21h

	mov cl,10h
	ror ebx,cl
	dec count
jnz genu
inc c

mov count,02h
cmp c,01h
jz inei
cmp c,02h
jz letn
cmp c,03h
jz done

inei:
mov ebx,edx1
jmp genu

letn:
mov ebx,ecx1
jmp genu



done:

mov ax,0001h
cpuid

mov eax1,eax
mov ebx1,ebx
mov ecx1,ecx
mov edx1,edx

lea dx,str3
mov ah,09h
int 21h

mov eax,eax1

and ax,000Fh  ;stepping id
mov dl,al
add dl,30h
mov ah,02h
int 21h

lea dx,str4
mov ah,09h
int 21h

mov eax,eax1

and ax,00F0h  ;model
ror al,4
add al,30h
cmp al,3Ah
jc next
	add al,07h
next:
mov dl,al
mov ah,02h
int 21h

lea dx,str5
mov ah,09h
int 21h
mov eax,eax1

and ax,0F00h  ;family
ror ax,8
add al,30h
mov dl,al
mov ah,02h
int 21h


lea dx,str6
mov ah,09h
int 21h
mov eax,eax1

and ax,3000h  ;type
ror ax,12
add al,30h
mov dl,al
mov ah,02h
int 21h




;;for dx
mov edx,edx1
and dx,0001h
cmp dx,0000h
jnz fpu
	lea dx,str9
	mov ah,09h
	int 21h
	jmp done2

fpu:

	lea dx,str10
	mov ah,09h
	int 21h


done2:
mov edx,edx1
and dx,0004h
cmp dx,0000h
jnz drs
	lea dx,str7
	mov ah,09h
	int 21h
	jmp done1

drs:

	lea dx,str8
	mov ah,09h
	int 21h

done1:
mov ah,4ch
int 21h
end start
